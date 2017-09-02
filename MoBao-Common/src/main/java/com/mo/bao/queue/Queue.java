package com.mo.bao.queue;

/**
 * Created by hadoop on 2017/9/3.
 */
public class Queue<T> {

    volatile T element;
    Queue<T> next;

    Queue(T t) {
        this.element = t;
    }

}
