package com.jemmy.concurrent.thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zhujiang.cheng
 * @since 2020/4/24
 */
public class FIFOMutex {

    private final AtomicBoolean locked = new AtomicBoolean(false);

    private final Queue<Thread> waiters = new ConcurrentLinkedDeque<>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            // ignore interrupts while waiting
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }

        waiters.remove();
        // reassert interrupt status on exit
        if (wasInterrupted) {
            current.interrupt();
        }
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

}
