/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: SynchronizeTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/11/2 21:18
 * Description: 
 */
package com.jemmy.concurrent;

/**
 * <pre>
 * SynchronizeTest
 *
 * @author Cheng Zhujiang
 * @date 2017/11/2
 */
public class SynchronizeTest {

    private static final Object obj = new Object();

    public static void main(String[] args) {
        synchronized (obj) {
            System.out.println("In the synchronized block");
        }
    }

}
