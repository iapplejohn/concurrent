/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ReentrantLockTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/22 14:37
 * Description: 
 */
package com.jemmy.concurrent.lock;

import org.junit.Test;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * ReentrantLockTest
 *
 * @author Cheng Zhujiang
 * @date 2017/9/22
 */
public class ReentrantLockTest {

    private static Lock fairLock = new ReentrantLock2(true);

    private static Lock unfairLock = new ReentrantLock2();

    @Test
    public void fair() throws InterruptedException {
        System.out.println("fair version");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(fairLock)) {
                @Override
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }

        // sleep 5000ms
        TimeUnit.MILLISECONDS.sleep(5000);
    }

    @Test
    public void unfair() throws InterruptedException {
        System.out.println("unfair version");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(unfairLock)) {
                @Override
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }

        // sleep 5000ms
        TimeUnit.MILLISECONDS.sleep(5000);
    }

    private static class Job implements Runnable {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    System.out.println("Lock by:" + Thread.currentThread().getName() + " and " + ((ReentrantLock2)lock).getQueuedThreads() + " waits.");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {

        private static final long serialVersionUID = 1773716895097002072L;

        public ReentrantLock2() {
            super();
        }

        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {
            return super.getQueuedThreads();
        }
    }
}
