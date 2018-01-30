/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: CounterThreadAtomicTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/29 22:47
 * Description: 
 */
package com.jemmy.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CounterThreadAtomicTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/29
 */
public class CounterThreadAtomicTest {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    int count = ai.incrementAndGet();
                    System.out.println("Thread 1 get " + count);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    int count = ai.incrementAndGet();
                    System.out.println("Thread 2 get " + count);
                }
            }
        }.start();
    }

}
