/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ScheduledExecuteServiceTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/16 11:11
 * Description: 
 */
package com.jemmy.concurrent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * <pre>
 * ScheduledExecuteServiceTest
 *
 * @author Cheng Zhujiang
 * @date 2017/9/16
 */
public class ScheduledExecuteServiceTest {

    private static final int POOL_SIZE = 4;

    private static ScheduledExecutorService ses = null;

    @Before
    public void setUp() {
        ses = Executors.newScheduledThreadPool(POOL_SIZE);
    }

    @After
    public void tearDown() {
        ses.shutdown();
    }

    @Test
    public void scheduled() throws ExecutionException, InterruptedException {
        MyCall task = new MyCall();
        System.out.println(System.currentTimeMillis() + " : scheduled...");
        // 延时100+1000毫秒打印
        ScheduledFuture<String> future = ses.schedule(task, 100, TimeUnit.MILLISECONDS);
        String result = future.get();
        System.out.println(System.currentTimeMillis() + " result: " + result);
    }

    @Test
    public void scheduledAtFixedRateTest() throws InterruptedException {
        MyCmd myCmd = new MyCmd();
        System.out.println(System.currentTimeMillis() + " : scheduledAtFixedRate...");
        // 首次延迟100毫秒，然后每隔max(2000,3000)毫秒打印
        ses.scheduleAtFixedRate(myCmd, 100, 2000, TimeUnit.MILLISECONDS);
        TimeUnit.MILLISECONDS.sleep(60000);
    }

    @Test
    public void scheduledAfFixedDelayTest() throws InterruptedException {
        MyCmd myCmd = new MyCmd();
        System.out.println(System.currentTimeMillis() + " : scheduledAfFixedDelay...");
        // 首次延迟100毫秒，然后每隔5000毫秒打印
        ses.scheduleWithFixedDelay(myCmd, 100, 2000, TimeUnit.MILLISECONDS);
        TimeUnit.MILLISECONDS.sleep(60000);
    }

    static class MyCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            TimeUnit.MILLISECONDS.sleep(1000);
            return "MyTask is done";
        }
    }

    static class MyCmd implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + " : MyCmd is done!");
        }
    }
}
