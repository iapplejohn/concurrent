/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: AtomicReferenceTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/11/2 21:01
 * Description: 
 */
package com.jemmy.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * <pre>
 * AtomicReferenceTest
 *
 * @author Cheng Zhujiang
 * @date 2017/11/2
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReferenceFieldUpdater<Cat, String> updater =
                AtomicReferenceFieldUpdater.newUpdater(Cat.class, String.class, "name");
        Cat cat1 = new Cat();
        updater.compareAndSet(cat1, "myCat", "myPet");
        System.out.println(cat1.name);

        cat1.name = "cat1";
        updater.compareAndSet(cat1, "myCat", "myPet");
        System.out.println(cat1.name);
    }

}
