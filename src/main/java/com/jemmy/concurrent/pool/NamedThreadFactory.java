package com.jemmy.concurrent.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.util.StringUtils;

/**
 * @author chengzhujiang
 * @since 2019/7/24
 */
public class NamedThreadFactory implements ThreadFactory {

    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    private final String prefix;

    private final boolean daemon;

    private final ThreadGroup threadGroup;

    public NamedThreadFactory() {
        this("wish-threadpool-" + threadNumber.getAndIncrement(), false);
    }

    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }

    public NamedThreadFactory(String prefix, boolean daemon) {
        this.prefix = StringUtils.isEmpty(prefix) ? "" : prefix + "-thread-";
        this.daemon = daemon;
        SecurityManager sm = System.getSecurityManager();
        threadGroup = (sm == null) ? Thread.currentThread().getThreadGroup() : sm.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = prefix + mThreadNum.getAndIncrement();
        Thread thread = new Thread(threadGroup, r, name, 0);
        thread.setDaemon(daemon);
        return thread;
    }
}
