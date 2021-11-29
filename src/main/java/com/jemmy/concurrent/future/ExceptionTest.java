package com.jemmy.concurrent.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhujiang.cheng
 * @since 2020/9/20
 */
public class ExceptionTest {

    public static void main(String[] args) {
        CompletableFuture<Integer> f0 = CompletableFuture
            .supplyAsync(() -> (7 / 0))
            .thenApply(r -> r * 10);
        System.out.println(f0.join());
    }
}
