/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: Counter.java
 * Author:   Cheng Zhujiang
 * Date:     2017/11/2 19:03
 * Description: 
 */
package com.jemmy.concurrent.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * Counter
 *
 * @author Cheng Zhujiang
 * @date 2017/11/2
 */
public class Counter {

    private AtomicInteger atomicI = new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(100);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }

        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    private void safeCount() {
        for (;;) {
            int i = atomicI.get();
            boolean success = atomicI.compareAndSet(i, ++i);
            if (success) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }

}
