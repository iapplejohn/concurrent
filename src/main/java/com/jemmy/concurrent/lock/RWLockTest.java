package com.jemmy.concurrent.lock;

/**
 * @author zhujiang.cheng
 * @since 2020/9/27
 */
public class RWLockTest {

    public static void main(String[] args) {
        int SHARED_SHIFT = 16;
        int max_read_lock_count = (1 << SHARED_SHIFT) - 1;
        System.out.println("max read lock count: " + max_read_lock_count);

        int max_write_lock_count = (1 << SHARED_SHIFT) - 1;
        System.out.println("max write lock count: " + max_write_lock_count);
    }

}
