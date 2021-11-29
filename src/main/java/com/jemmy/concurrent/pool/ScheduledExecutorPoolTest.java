package com.jemmy.concurrent.pool;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 调度线程池，如果前面执行抛异常未捕获，后面调度不会进行
 *
 * @author zhujiang.cheng
 * @since 2020/4/13
 */
public class ScheduledExecutorPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(5, new NamedThreadFactory());
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {

                int i = 0;
                try {
                    System.out.println("executing the task" + LocalTime.now());
                    TimeUnit.SECONDS.sleep(5);
                    FileInputStream fis = new FileInputStream(Objects
                        .requireNonNull(this.getClass().getClassLoader().getResource("logback.xml")).getPath());
                    i = 2 / 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }, 1, 10, TimeUnit.SECONDS);
    }

}
