package com.jemmy.concurrent.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zhujiang.cheng
 * @since 2020/4/24
 */
public class LockSupportTest {

    public static void main(String[] args) {
        LockSupportThread thread = new LockSupportThread();
//        thread.setDaemon(true);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
//            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object blocker = LockSupport.getBlocker(thread);
        System.out.println("The block is " + blocker);
        LockSupport.unpark(thread);
        System.out.println("Main thread is finished");
    }

}
