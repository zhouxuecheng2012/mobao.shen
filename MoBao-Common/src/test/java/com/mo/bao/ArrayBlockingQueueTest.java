package com.mo.bao;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by hadoop on 2017/9/4.
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue(10);
        try {
            blockingQueue.put("11");
            String result = blockingQueue.take();
            System.out.print(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

        try {

            linkedBlockingQueue.put("111");
            linkedBlockingQueue.poll();


            linkedBlockingQueue.offer("222");
            linkedBlockingQueue.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
