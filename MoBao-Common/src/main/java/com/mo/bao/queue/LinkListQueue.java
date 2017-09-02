package com.mo.bao.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hadoop on 2017/9/3.
 */
public class LinkListQueue<T> {

    private final AtomicInteger counters = new AtomicInteger(0);
    private transient Queue<T> _$6;
    private transient Queue<T> _$5 = this._$6 = new Queue(null);
    private final ReentrantLock _$4 = new ReentrantLock();
    private final Condition _$3 = this._$4.newCondition();
    private final ReentrantLock _$2 = new ReentrantLock();


}
