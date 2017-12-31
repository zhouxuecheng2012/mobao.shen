package com.mo.bao.callback;

/**
 * Created by hadoop on 2017/12/31.
 */
@FunctionalInterface
public interface TestInterface<T,R> {

    // 抽象方法
    public R execute(T t);

    // java.lang.Object中的方法不是抽象方法
    public boolean equals(Object var1);

    // default不是抽象方法
    public default void defaultMethod() {

    }

    // static不是抽象方法
    public static void staticMethod() {

    }

}
