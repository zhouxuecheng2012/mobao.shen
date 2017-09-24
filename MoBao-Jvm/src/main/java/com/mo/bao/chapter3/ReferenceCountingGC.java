package com.mo.bao.chapter3;

/**
 * Created by hadoop on 2017/9/23.
 * [GC (System.gc())
 [PSYoungGen: 7219K->856K(36352K)] 7219K->864K(119808K), 0.0595989 secs]
 [Times: user=0.00 sys=0.00, real=0.06 secs]
 [Full GC (System.gc())
 [PSYoungGen: 856K->0K(36352K)]
 [ParOldGen: 8K->744K(83456K)] 864K->744K(119808K),
 [Metaspace: 3066K->3066K(1056768K)],
 0.0076095 secs]
 [Times: user=0.00 sys=0.00, real=0.01 secs]

 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }


}
