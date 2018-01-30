/*
 * Copyright (C), 2014-2018, 杭州小卡科技有限公司
 * FileName: InterruptTest.java
 * Author:   Cheng Zhujiang
 * Date:     2018/1/22 20:30
 * Description: 
 */
package com.jemmy.jvm;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 线程中断
 *
 * @author Cheng Zhujiang
 * @date 2018/1/22
 */
public class InterruptTest extends Thread {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted!");
                break;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interruted When Sleep");
                //设置中断状态，抛出异常后会清除中断标记位
//                Thread.currentThread().interrupt();
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptTest test = new InterruptTest();
        test.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        test.interrupt();
    }

}
