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

/**
 * Created by hadoop on 2017/12/27.
 * (2)异步CallBack
 */
public class AsyncCallbackTest {

    private static HttpAsyncClient httpAsyncClient;

    public static CompletableFuture<String> getHttpData(String url) {
        CompletableFuture asyncFuture = new CompletableFuture();
        HttpAsyncRequestProducer producer = HttpAsyncMethods.create(new HttpPost(url));
        HttpAsyncResponseConsumer consumer = new BasicAsyncResponseConsumer();
        FutureCallback callback = new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse response) {
                asyncFuture.complete(response);
            }

            @Override
            public void failed(Exception e) {
                asyncFuture.completeExceptionally(e);
            }

            @Override
            public void cancelled() {
                asyncFuture.cancel(true);
            }
        };
        httpAsyncClient.execute(producer, consumer, callback);
        return asyncFuture;
    }

}
