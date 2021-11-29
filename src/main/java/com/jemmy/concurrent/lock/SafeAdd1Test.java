package com.jemmy.concurrent.lock;

/**
 * @author zhujiang.cheng
 * @since 2021/3/11
 */
public class SafeAdd1Test {

    public int i;

    public void add1() {
        synchronized (this) {
            i++;
        }
    }

}
