/*
 * Copyright (C), 2014-2018, 杭州小卡科技有限公司
 * FileName: VisibilityTest.java
 * Author:   Cheng Zhujiang
 * Date:     2018/1/22 20:16
 * Description: 
 */
package com.jemmy.jvm;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 这个程序在 client 模式下是能停止线程做自增操作的，但是在 server 模式先将是无限循环。
 * （server模式下JVM优化更多）
 * 64位的系统上面大多都是server模式，在server模式下运行：
 * finish main
 * true
 *
 * @author Cheng Zhujiang
 * @date 2018/1/22
 */
public class VisibilityTest extends Thread {

    private boolean stop;

    @Override
    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println("finish loop,i=" + i);
    }

    public void stopIt() {
        stop = true;
    }

    public boolean getStop() {
        return stop;
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest v = new VisibilityTest();
        v.start();

        TimeUnit.MILLISECONDS.sleep(1000);
        v.stopIt();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("finish main");
        System.out.println(v.getStop());
    }
}
