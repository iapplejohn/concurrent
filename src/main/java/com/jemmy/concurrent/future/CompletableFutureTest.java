package com.jemmy.concurrent.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author zhujiang.cheng
 * @since 2020/9/19
 */
public class CompletableFutureTest {

    private static Random random = new Random();

    public static void main(String[] args) {
        // 任务1：洗水壶->烧开水
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1: 洗水壶...");
            sleep(1, TimeUnit.SECONDS);
        });

        //任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶...");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T2:洗茶杯...");
            sleep(2, TimeUnit.SECONDS);

            System.out.println("T2:拿茶叶...");
            sleep(1, TimeUnit.SECONDS);

            return "龙井";
        });

        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T1:拿到茶叶:" + tf);
            System.out.println("T1:泡茶..." + __);
            return "上茶:" + tf;
        });

        //等待任务3执行结果
        System.out.println(f3.join());
    }

    public static void sleep(int t, TimeUnit unit) {
        try {
            unit.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getRandom(int lower, int upper) {
        int interval = upper - lower;
        return random.nextInt(interval) + lower;
    }
}
