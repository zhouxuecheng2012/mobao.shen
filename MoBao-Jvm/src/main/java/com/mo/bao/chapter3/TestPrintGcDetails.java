package com.mo.bao.chapter3;

/**
 * Created by hadoop on 2017/9/23.
 * 从上图我们可以看出 GC 的主要收集区域，包括
 * PSYoungGen（年轻代）、
 * ParOldGen（老年代）、
 * Metaspace（元数据区）。
 */
public class TestPrintGcDetails {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            byte[] b = new byte[1 * 1024 * 1024];
        }
        System.gc();
    }

}
