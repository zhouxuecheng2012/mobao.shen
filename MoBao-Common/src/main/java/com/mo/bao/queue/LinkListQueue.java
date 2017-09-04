package com.mo.bao.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hadoop on 2017/9/3.
 */
public class LinkListQueue<T> {

    private final AtomicInteger counters = new AtomicInteger(0);
    private transient Queue<T> head;
    private transient Queue<T> tail = head = new Queue(null);
    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition condition = takeLock.newCondition();
    private final ReentrantLock putLock = new ReentrantLock();
    /** Wait queue for waiting puts */
    private final Condition notFull = putLock.newCondition();

    private void add(T t) {
        tail.next = new Queue(t);
        tail = tail.next;
    }

    private T get() {
        // assert takeLock.isHeldByCurrentThread();
        // assert head.item == null;
        Queue<T> h = head;
        Queue<T> first = h.next;
        h.next = h; // help GC

        head = first;
        T x = first.item;
        first.item = null;
        return x;
    }

    private void notifyTake() {
        takeLock.lock();
        try {
            condition.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void lock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    private void unclock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    public boolean offer(T paramE) {
        if (paramE == null) {
            throw new NullPointerException();
        }
        int i = -1;
        putLock.lock();
        try {
            add(paramE);
            i = counters.getAndIncrement();
        } finally {
            putLock.unlock();
        }
        if (i == 0) {
            notifyTake();
        }
        return i >= 0;
    }

    public T take() throws InterruptedException {
        int i = -1;
        takeLock.lockInterruptibly();
        Object localObject;
        try {
            try {
                //保证被唤醒的线程重新判断标志位
                while (counters.get() == 0) {
                    condition.await();
                }
            } catch (InterruptedException localInterruptedException) {
                condition.signal();
                throw localInterruptedException;
            }
            localObject = get();
            i = counters.getAndDecrement();
            if (i > 1) {
                condition.signal();
                //condition.signalAll();
            }
        } finally {
            takeLock.unlock();
        }
        return (T) localObject;
    }

    public void clear(){
        lock();
        try{
            this.head.next = null;
            if((this.head.item != null)){
                throw new AssertionError();
            }
            this.tail = this.head;
        }finally{
            unclock();
        }
    }

}
