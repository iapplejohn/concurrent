package com.jemmy.concurrent.future;

import static com.jemmy.concurrent.future.CompletableFutureTest.getRandom;
import static com.jemmy.concurrent.future.CompletableFutureTest.sleep;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author zhujiang.cheng
 * @since 2020/9/19
 */
public class ApplyToEitherTest {

    public static void main(String[] args) {
        CompletableFuture<String> f1 =
            CompletableFuture.supplyAsync(() -> {
                int t = getRandom(5, 10);
                sleep(t, TimeUnit.SECONDS);
                return String.valueOf(t);
            });

        CompletableFuture<String> f2 =
            CompletableFuture.supplyAsync(() -> {
                int t = getRandom(5, 10);
                sleep(t, TimeUnit.SECONDS);
                return String.valueOf(t);
            });

        CompletableFuture<String> f3 =
            f1.applyToEither(f2, s -> s);

        System.out.println(f3.join());
    }
}
