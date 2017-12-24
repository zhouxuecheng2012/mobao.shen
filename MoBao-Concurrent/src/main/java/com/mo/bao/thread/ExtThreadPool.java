package com.mo.bao.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hadoop on 2017/11/19.
 */
public class ExtThreadPool {

    public static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行"+":Thread ID:"+Thread.currentThread().getName()+
            ",Task Name="+name);
        }

    }

    public static void main(String[] args) {
        new ThreadPoolExecutor(
                5,
                5,
                0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<Runnable>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
            }

            @Override
            protected void terminated() {
                super.terminated();
            }
        };
    }

}
