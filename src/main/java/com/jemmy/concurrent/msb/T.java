package com.jemmy.concurrent.msb;

/**
 * 用hsdis观察synchronized和volatile的编译情况
 *
 * 需要安装hsdis
 *
 * java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly T
 *
 * @author zhujiang.cheng
 * @since 2020/4/24
 */
public class T {

    public static volatile int i = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            m();
            n();
        }
    }

    public static synchronized void m() {

    }

    public static void n() {
        i = 1;
    }
}
