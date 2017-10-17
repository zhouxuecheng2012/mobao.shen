package com.mo.bao.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2017/10/15.
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class MonitoringTest {

    /**
     * -Xms100m -Xmx100m -XX:+UseSerialGC
     */
    public static void main(String[] args) throws InterruptedException {
           fillHeap(1000);
    }

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(100);
            list.add(new OOMObject());
        }
        System.gc();
    }

}
