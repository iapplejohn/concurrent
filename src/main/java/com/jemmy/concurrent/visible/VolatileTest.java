package com.jemmy.concurrent.visible;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhujiang.cheng
 * @since 2021/2/20
 */
class Data {
//    volatile int num = 0;

    volatile AtomicInteger num = new AtomicInteger();

    public void increase() {
//        num++;
        num.incrementAndGet();
    }
}

public class VolatileTest {

    public static void main(String[] args) {
        Data data = new Data();

        // 100 个线程操作 num 累加
        for (int i = 1; i <= 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        data.increase();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // 等待上述线程执行完 -> 数值2表示只有主线程和GC线程在运行
        while (Thread.activeCount() > 2) {
            // 主线程让出 CPU 时间片
            Thread.yield();
        }
        System.out.println(data.num);
    }
}
