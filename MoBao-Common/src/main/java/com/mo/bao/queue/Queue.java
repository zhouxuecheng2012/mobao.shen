package com.mo.bao.queue;

/**
 * Created by hadoop on 2017/9/3.
 */
public class Queue<T> {

    volatile T item;
    Queue<T> next;

    Queue(T t) {
        this.item = t;
    }

}
