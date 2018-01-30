/*
 * Copyright (C), 2014-2018, 杭州小卡科技有限公司
 * FileName: DaemonTest.java
 * Author:   Cheng Zhujiang
 * Date:     2018/1/22 21:08
 * Description: 
 */
package com.jemmy.jvm;

/**
 * <pre>
 * http://www.importnew.com/21239.html
 * 3. 守护线程
 *
 * @author Cheng Zhujiang
 * @date 2018/1/22
 */
public class DaemonTest {

    public static class DaemonThread extends Thread {
        @Override
        public void run() {
            for (int  i = 0; i < 10000000; i++) {
                System.out.println("hi");
            }
        }
    }

    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();
        dt.setDaemon(true);
        dt.start();
    }
}
