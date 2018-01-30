/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: CounterThread.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/29 15:26
 * Description: 
 */
package com.jemmy.concurrent;

/**
 * 两个线程都对同一个int变量自增，怎么保证线程安全？-中恒云能源
 * // 方案1：synchronized关键字
 *
 * @author Cheng Zhujiang
 * @date 2017/7/29
 */
public class CounterThreadTest {

    public static void main(String[] args) {
        A a = new A();

        for (int  j = 0; j < 100; j++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        int c = a.incAndGet();
                        System.out.println("Thread " + i + " get: " + c);
                    }
                }
            }.start();
        }

//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    int c = a.incAndGet();
//                    System.out.println("Thread 2 get: " + c);
//                }
//            }
//        }.start();
//
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000; i++) {
//                    int c = a.incAndGet();
//                    System.out.println("Thread 3 get: " + c);
//                }
//            }
//        }.start();
    }

    static class A {
        // It would cause concurrent issue if only use volatile
        /**volatile*/ int count;

        synchronized int incAndGet() {
            ++count;
            return count;
        }
    }
}
