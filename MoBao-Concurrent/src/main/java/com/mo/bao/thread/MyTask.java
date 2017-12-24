package com.mo.bao.thread;

import java.util.concurrent.Callable;

/**
 * Created by hadoop on 2017/11/19.
 */
public class MyTask implements Callable {

    @Override
    public Boolean call() throws Exception {
        // 总计耗时约10秒
        for (int i = 0; i < 100L; i++) {
            Thread.sleep(100); // 睡眠0.1秒
            System.out.print('-');
        }
        return Boolean.TRUE;
    }

}
