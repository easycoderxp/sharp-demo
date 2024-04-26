package com.sharp.sharp.thread.build;

import com.sharp.sharp.thread.model.ThreadB;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步回调 CompletableFuture
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-22 21:03:27
 */
public class BuildE {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(new ThreadB());


        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
//            int i = 1/0;
            return 1024;
        });

        completableFuture2.whenComplete((t, u) -> {
            System.out.println(t);
            if (Objects.nonNull(u)) {
                System.out.println(u.getMessage());
            }
        }).get();
        completableFuture1.get();
    }
}
