package com.mo.bao.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by hadoop on 2017/12/24.
 */
public class CompletableFutureTest {

    public static Integer calc(Integer param) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return param * param;
    }

    public static Integer calc_exception(Integer param) {
        return param / 0;
    }


    private static void completableBasic() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calc_exception(50))
                .exceptionally(ex -> {
                    System.out.println(ex.toString());
                    return 0;
                })
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();
    }

    public static Integer calc_combine(Integer param) {
        return param / 2;
    }

    private static void completableCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calc_combine(50))
                .thenCompose((i)->CompletableFuture.supplyAsync(() -> calc_combine(i)))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();
    }

    private static void completableCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(() -> calc_combine(50));
        CompletableFuture<Integer> intFuture2 = CompletableFuture.supplyAsync(() -> calc_combine(25));

        CompletableFuture<Void> fu = intFuture.thenCombine(intFuture2,(i,j)->(i+j))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //completableCompose();
        completableCombine();
    }

}
