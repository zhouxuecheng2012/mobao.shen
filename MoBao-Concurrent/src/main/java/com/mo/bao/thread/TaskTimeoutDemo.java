package com.mo.bao.thread;

import java.util.concurrent.*;

/**
 * Created by hadoop on 2017/8/13.
 */
public class TaskTimeoutDemo {

    public static void main(String[] args) {
        System.out.println("Start ...");

        ExecutorService exec = Executors.newCachedThreadPool();

        //testTask(exec, 15); // 任务成功结束后等待计算结果，不需要等到15秒
        testTask(exec, 1); // 只等待5秒，任务还没结束，所以将任务中止

        exec.shutdown();
        System.out.println("End!");
    }

    public static void testTask(ExecutorService exec, int timeout) {
        MyTask task = new MyTask();
        Future<Boolean> future = exec.submit(task);
        Boolean taskResult = null;
        String failReason = null;
        try {
            // 等待计算结果，最长等待timeout秒，timeout秒后中止任务
            taskResult = future.get(timeout, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            failReason = "主线程在等待计算结果时被中断！";
        } catch (ExecutionException e) {
            failReason = "主线程等待计算结果，但计算抛出异常！";
        } catch (TimeoutException e) {
            failReason = "主线程等待计算结果超时，因此中断任务线程！";
            exec.shutdownNow();
        }

        System.out.println("\ntaskResult : " + taskResult);
        System.out.println("failReason : " + failReason);
    }

}

class MyTask implements Callable<Boolean> {
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