package com.mo.bao.chapter6;

/**
 * Created by hadoop on 2017/11/2.
 */
public class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init DeadLockClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "run rover");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);

        thread1.start();
        thread2.start();

    }

}
