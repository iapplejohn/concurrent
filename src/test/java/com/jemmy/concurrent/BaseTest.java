/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: BaseTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/4/23 19:45
 * Description: 
 */
package com.jemmy.concurrent;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * BaseTest
 *
 * @author Cheng Zhujiang
 * @date 2017/4/23
 */
@ContextConfiguration(locations = {"classpath:spring/chapter6/base.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests {

    public void test() {
        System.out.print("I am base test!");
    }

}
