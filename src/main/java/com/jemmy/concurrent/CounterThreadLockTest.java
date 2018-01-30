/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: CounterThreadLockTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/29 21:55
 * Description: 
 */
package com.jemmy.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * CounterThreadLockTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/29
 */
public class CounterThreadLockTest {

    public static void main(String[] args) {
        A a = new A();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    int c = a.incAndGet();
                    System.out.println("Thread 1 get: " + c);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    int c = a.incAndGet();
                    System.out.println("Thread 2 get: " + c);
                }
            }
        }.start();
    }

    static class A {
        // It would cause concurrent issue if only use volatile
        int count;
        ReentrantLock lock = new ReentrantLock();

        int incAndGet() {
            lock.lock();

            try {
                ++count;
                return count;
            } finally {
                lock.unlock();
            }
        }
    }
}
