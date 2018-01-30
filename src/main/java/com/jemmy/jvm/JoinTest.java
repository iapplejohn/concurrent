/*
 * Copyright (C), 2014-2018, 杭州小卡科技有限公司
 * FileName: JoinTest.java
 * Author:   Cheng Zhujiang
 * Date:     2018/1/22 21:05
 * Description: 
 */
package com.jemmy.jvm;

/**
 * <pre>
 * http://www.importnew.com/21239.html
 * 2.6 join和yeild
 *
 * @author Cheng Zhujiang
 * @date 2018/1/22
 */
public class JoinTest {

    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
//        at.join();
        System.out.println(i);
    }
}
