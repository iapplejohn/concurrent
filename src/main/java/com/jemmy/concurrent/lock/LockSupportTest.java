/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: LockSupportTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/22 14:15
 * Description: 
 */
package com.jemmy.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * <pre>
 * LockSupportTest
 *
 * @author Cheng Zhujiang
 * @date 2017/9/22
 */
public class LockSupportTest {

    public static void main(String[] args) {
        System.out.println("start");
        LockSupport.parkNanos(1000000000);//一开始会block线程，直到给定时间过去后才往下走
        System.out.println("end");

        System.out.println("start");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.parkNanos(1000000000);//不会block，因为一开始给了一个permit
        System.out.println("end");

        System.out.println("start");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        LockSupport.parkNanos(1000000000);
        System.out.println("inter");
        LockSupport.parkNanos(1000000000);
        System.out.println("end");
    }
}
