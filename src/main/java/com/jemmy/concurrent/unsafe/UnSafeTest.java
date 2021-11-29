package com.jemmy.concurrent.unsafe;

import sun.misc.Unsafe;

/**
 * @author zhujiang.cheng
 * @since 2020/9/27
 */
public class UnSafeTest {

    private String userName;

    private String password;

    private static long offset;

    private static final Unsafe unsafe;

    static {
        unsafe = Unsafe.getUnsafe();
        Class<?> clazz = UnSafeTest.class;
        try {
            offset = unsafe.objectFieldOffset(clazz.getDeclaredField("password"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnSafeTest test = new UnSafeTest();
        System.out.println(test.password);
        test.password = "123456";
        unsafe.getObject(test, offset);
    }
}
