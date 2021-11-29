package com.jemmy.concurrent.thread;

/**
 * 测试Thread.yield()使用情况
 *
 * @author zhujiang.cheng
 * @since 2020/5/20
 */
public class XKThread extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            // cpu让给其他资源导致速度变慢
            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时 = " + (endTime - beginTime) + " 毫秒! ");
    }

    public static void main(String[] args) {
        XKThread xkThread = new XKThread();
        xkThread.start();
    }
}
