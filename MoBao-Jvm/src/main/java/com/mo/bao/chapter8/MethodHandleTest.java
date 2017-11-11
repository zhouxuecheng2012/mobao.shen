package com.mo.bao.chapter8;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles.Lookup;
/**
 * Created by hadoop on 2017/11/11.
 */
public class MethodHandleTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintMH(obj).invokeExact("icyfenix111");
    }

    private static MethodHandle getPrintMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {
        /**
         * MethodType代表方法类型 方法返回值(第一个参数) 具体参数(第二个参数)
         *
         */
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
    }


}
