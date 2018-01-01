package com.mo.bao.callback;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by hadoop on 2017/12/29.
 * (3)异步编排
 */
public class CompletableFutureTest {

    //3个服务并非调用，然后对结果合并处理，不阻塞主线程
    private static void test1(){
       MyService service = new MyService();

        CompletableFuture<String> future1 = service.getHttpData("http://www.jd.com");
        CompletableFuture<String> future2 = service.getHttpData("http://www.jd.com");
        CompletableFuture<String> future3 = service.getHttpData("http://www.jd.com");


        CompletableFuture.allOf(future1,future2,future3)
                .thenApplyAsync(
                (Void) ->{
                    try {
                        future1.get();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                  return  null;
                })
                .exceptionally(e->{
                   System.out.println(e.toString());
                   return null;
        });
    }

    public static void main(String[] args) {



    }

}
