/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: WaitNotify.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/22 18:43
 * Description: 
 */
package com.jemmy.concurrent.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * WaitNotify
 *
 * @author Cheng Zhujiang
 * @date 2017/9/22
 */
public class WaitNotify {

    volatile static boolean flag = true;

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
        //TimeUnit.SECONDS.sleep(10);
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                while (flag) {
                    System.out.println(Thread.currentThread()
                        + " flag is true. wait@ "
                            + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread()
                    + " flag is false. running@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                System.out.println(Thread.currentThread()
                    + " hold lock. notify @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread()
                    + " hold lock again. sleep@ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
