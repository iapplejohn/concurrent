package com.jemmy.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程优先级
 *
 * @author zhujiang.cheng
 * @since 2020/5/20
 */
public class ThreadPriority {

    public static void main(String[] args) throws InterruptedException {
        ThreadLow low = new ThreadLow();
        low.setPriority(2);
        low.start();

        ThreadHigh high = new ThreadHigh();
        high.setPriority(8);
        high.start();

        TimeUnit.MILLISECONDS.sleep(2000);
        low.stop();
        high.stop();

        System.out.println("low  = " + low.getCount());
        System.out.println("high = " + high.getCount());
    }

    static class ThreadLow extends Thread {
        private int count = 0;

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            while (true) {
                count++;
            }
        }
    }

    static class ThreadHigh extends Thread {
        private int count = 0;

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            while (true) {
                count++;
            }
        }
    }
}
