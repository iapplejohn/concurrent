/*
 * Copyright (C), 2014-2018, 杭州小卡科技有限公司
 * FileName: Test.java
 * Author:   Cheng Zhujiang
 * Date:     2018/1/22 20:35
 * Description: 
 */
package com.jemmy.jvm;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 说明两个线程都争夺到了锁，但是控制台的红灯还是亮着的，说明t1,t2一定有线程没有执行完。
 * 我们dump出堆来看看，发现t2一直被suspend。这样就造成了死锁。
 *
 * @author Cheng Zhujiang
 * @date 2018/1/22
 */
public class Test {

    static final Object u = new Object();
    static TestSuspendThread t1 = new TestSuspendThread("t1");
    static TestSuspendThread t2 = new TestSuspendThread("t2");

    public static class TestSuspendThread extends Thread {
        public TestSuspendThread(String name) {
            setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t2.start();
        System.out.println("------");
        t1.resume();
        System.out.println("+++++");
//        TimeUnit.MILLISECONDS.sleep(1);
        t2.resume();
        t1.join();
        t2.join();
    }
}
