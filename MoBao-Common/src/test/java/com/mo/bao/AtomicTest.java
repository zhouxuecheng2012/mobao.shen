package com.mo.bao;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 2017/9/3.
 */
public class AtomicTest {


    public static void main(String[] args) {
        AtomicInteger count =new AtomicInteger(0);
        System.out.println(count.getAndIncrement());
        System.out.println(count.getAndIncrement());
        System.out.println(count.getAndIncrement());
        System.out.println(count.getAndIncrement());
    }

}
