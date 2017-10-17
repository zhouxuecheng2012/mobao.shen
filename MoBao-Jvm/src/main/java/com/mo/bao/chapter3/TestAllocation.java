package com.mo.bao.chapter3;
/**
 * Created by hadoop on 2017/10/12.
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        //testAllocation();
        //testPretenureSizeThreshold();
        testTenuringThreshold();
    }

    /**
     * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        //-XX:MaxTenuringThreshold=1进入老年代
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    /**
     * PretenureSizeThreshold令大于这设置的值，直接在老年代分配
     * PretenureSizeThreshold只对Serial和ParNew 2款收集器有效
     */
    //-verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
    // -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     * -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     * -XX:+UseSerialGC
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

}
