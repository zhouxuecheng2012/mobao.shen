package com.mo.bao.chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by hadoop on 2017/10/17.
 */
public class DirectMemoryOOM {

    private static final int
            _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeFiled = Unsafe.class.getDeclaredFields()[0];
        unsafeFiled.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeFiled.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
