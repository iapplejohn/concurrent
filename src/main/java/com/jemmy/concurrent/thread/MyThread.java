package com.jemmy.concurrent.thread;

/**
 * @author zhujiang.cheng
 * @since 2020/4/13
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("i="+(i+1));
        }
    }
}
