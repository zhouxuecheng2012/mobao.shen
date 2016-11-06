package com.mo.bao.sequence;

/**
 * Created by hadoop on 2016/11/7.
 */
public abstract class AbstractSequenceManager {

    /**
     * 由各个业务自己实现
     * @param sequenceName 名称
     * @return 该名称的值
     */
    public abstract Long reInitSequence(String sequenceName);

}
