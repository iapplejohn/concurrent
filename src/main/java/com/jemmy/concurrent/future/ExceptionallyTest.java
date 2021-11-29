package com.jemmy.concurrent.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhujiang.cheng
 * @since 2020/9/20
 */
public class ExceptionallyTest {

    public static void main(String[] args) {
        CompletableFuture<Integer> f0 = CompletableFuture
            .supplyAsync(() -> 7 / 0)
            .thenApply(r -> r * 10)
            .exceptionally(e -> {
                    System.err.println(e);
                    return 0;
                }
            );
        System.out.println(f0.join());
    }

}
