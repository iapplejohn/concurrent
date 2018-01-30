/*
 * Copyright (C), 2014-2018, 杭州小卡科技有限公司
 * FileName: OrderExample.java
 * Author:   Cheng Zhujiang
 * Date:     2018/1/22 20:22
 * Description: 
 */
package com.jemmy.jvm;

/**
 * <pre>
 * 计算机在执行代码时，不一定会按照程序的顺序来执行。
 *
 * @author Cheng Zhujiang
 * @date 2018/1/22
 */
public class OrderExample {

    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a + 1;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        OrderExample o = new OrderExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                o.writer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                o.reader();
            }
        });
        t1.start();
        t2.start();
    }
}
