package com.jemmy.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * 对一个线程执行interrupt方法，正常是不会响应中断的
 *
 * @author zhujiang.cheng
 * @since 2020/4/13
 */
public class Run {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
