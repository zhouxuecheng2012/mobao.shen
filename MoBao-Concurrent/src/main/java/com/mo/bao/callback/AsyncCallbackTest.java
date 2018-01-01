package com.mo.bao.callback;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.BasicAsyncResponseConsumer;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by hadoop on 2017/12/27.
 * (2)异步CallBack
 */
public class AsyncCallbackTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyService service = new MyService();

        CompletableFuture<String> future = service.getHttpData("http://www.jd.com");
        String result = future.get();
    }

}
