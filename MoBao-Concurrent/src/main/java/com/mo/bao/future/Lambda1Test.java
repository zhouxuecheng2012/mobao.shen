package com.mo.bao.future;

import java.util.function.Function;

/**
 * Created by hadoop on 2017/12/24.
 */
public class Lambda1Test {

    public static void main(String[] args) {
        final int num = 2;
        Function<Integer, Integer> stringConverter = (from) -> from * num;
        System.out.println(stringConverter.apply(3));
    }

}
