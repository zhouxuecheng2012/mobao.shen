package com.mo.bao.callback;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by hadoop on 2017/12/31.
 * (1)异步Future
 */
public class AsyncFutureTest {

    final static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();
        Future<Map<String, String>> future1 = null;
        Future<Integer> future2 = null;
        executor.execute(() -> {
            rpcService.getRpcResult();
        });
        executor.execute(() -> {
            httpService.getHttpResult();
        });
        Map<String, String> result1 = future1.get(300, TimeUnit.MILLISECONDS);
        Integer result2 = future2.get(300, TimeUnit.MILLISECONDS);
    }

    static class RpcService {
        Map<String, String> getRpcResult() {
            return null;
        }
    }

    static class HttpService {
        Integer getHttpResult() {
            return 0;
        }
    }

}
