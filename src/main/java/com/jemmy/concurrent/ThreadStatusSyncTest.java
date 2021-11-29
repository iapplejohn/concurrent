package com.jemmy.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author zhujiang.cheng
 * @since 2020/2/24
 */
public class ThreadStatusSyncTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new SyncWork("thread1"));
        Thread thread2 = new Thread(new SyncWork("thread2"));

        thread1.start();
        thread2.start();

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("thread1状态" + thread1.getState().toString());
        System.out.println("thread2状态" + thread2.getState().toString());
    }

    static class SyncWork implements Runnable {

        private String name;

        public SyncWork(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (SyncWork.class) {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(name + "执行完成");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
