package com.mo.bao.queue;

/**
 * Created by hadoop on 2017/9/4.
 */
public interface DispatchQueueProcessor<T> {

    public abstract void ProcessQueueElement(LinkListQueue<T> linkListQueue, T t, int paramInt);


}
