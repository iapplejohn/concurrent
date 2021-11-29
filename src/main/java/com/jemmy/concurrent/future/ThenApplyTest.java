package com.jemmy.concurrent.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhujiang.cheng
 * @since 2020/9/19
 */
public class ThenApplyTest {

    public static void main(String[] args) {
        CompletableFuture<String> f0 =
            CompletableFuture.supplyAsync(() -> "Hello World")
            .thenApply(s -> s + " QQ")
            .thenApply(String::toUpperCase);

        // 输出结果 HELLO WORLD QQ
        System.out.println(f0.join());
    }
}
