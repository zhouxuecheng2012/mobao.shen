package com.mo.bao.chapter8;

/**
 * Created by hadoop on 2017/11/5.
 */
public class Client {

    public static void main(String[] args) {
        ServiceA sa = new ServiceAImpl();
        ServiceB sb = new ServiceBImpl();
        sa.methodA();
        sb.methodB();
        System.out.println("=====================");
        Facade f = new Facade();
        f.methodA();
        f.methodB();
        f.methodC();
    }

}
