package com.mo.bao.callback;

/**
 * Created by hadoop on 2017/12/31.
 */
public class TestInterfaceImpl implements TestInterface<String,Integer> {

    @Override
    public Integer execute(String s) {
        Integer i = Integer.parseInt(s);
        return i / 5;
    }

}
