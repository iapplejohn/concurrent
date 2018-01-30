/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: CounterThreadStaticTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/29 21:46
 * Description: 
 */
package com.jemmy.concurrent;

/**
 * CounterThreadStaticTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/29
 */
public class CounterThreadStaticTest {

    static int count = 0;

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (CounterThreadStaticTest.class) {
                        ++count;
                        System.out.println("Thread 1 get: " + count);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (CounterThreadStaticTest.class) {
                        ++count;
                        System.out.println("Thread 2 get: " + count);
                    }
                }
            }
        }.start();
    }

}
