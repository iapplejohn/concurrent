package com.jemmy.concurrent.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport响应中断，直接返回，不会抛异常
 *
 * @author zhujiang.cheng
 * @since 2020/4/24
 */
public class LockSupportThread extends Thread {

    @Override
    public void run() {
        try {
            LockSupport.park(this);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("park is interrupted");
        }
        System.out.println("thread is resumed from park");
    }
}
