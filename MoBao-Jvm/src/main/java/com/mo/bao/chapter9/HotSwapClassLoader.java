package com.mo.bao.chapter9;

/**
 * Created by hadoop on 2017/11/14.
 */
public class HotSwapClassLoader extends ClassLoader {

    public HotSwapClassLoader() {
       super(HotSwapClassLoader.class.getClassLoader());
   }

    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }

}
