package com.jemmy.concurrent.lock;

/**
 * @author zhujiang.cheng
 * @since 2021/3/11
 */
public class SafeAdd1Test2 {

    public int i;

    public synchronized void add1() {
        i++;
    }

}
