/*
 * Copyright (C), 2014-2018, 杭州小卡科技有限公司
 * FileName: PriorityTest.java
 * Author:   Cheng Zhujiang
 * Date:     2018/1/22 21:11
 * Description: 
 */
package com.jemmy.jvm;

/**
 * <pre>
 * http://www.importnew.com/21239.html
 * 4. 线程优先级
 * 当然并不一定是高优先级一定先完成。再多次运行后发现，高优先级完成的概率比较大，但是低优先级还是有可能先完成的。
 *
 * @author Cheng Zhujiang
 * @date 2018/1/22
 */
public class PriorityTest {

    public static class High extends Thread {

        static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (PriorityTest.class) {
                    count++;
                    if (count > 10000000) {
                        System.out.println("High");
                        break;
                    }
                }
            }
        }
    }

    public static class Low extends Thread {

        static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (PriorityTest.class) {
                    count++;
                    if (count > 10000000) {
                        System.out.println("Low");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        High high = new High();
        Low low = new Low();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }
}
