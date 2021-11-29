package com.jemmy.concurrent.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhujiang.cheng
 * @since 2021/2/5
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String, Boolean> map = new ConcurrentHashMap<>();
        Boolean origin1 = map.putIfAbsent("abc", Boolean.TRUE);
        Boolean origin2 = map.putIfAbsent("abc", Boolean.TRUE);
        Boolean origin3 = map.remove("abc");
        Boolean origin4 = map.putIfAbsent("abc", Boolean.TRUE);
        System.out.println("origin4 = " + origin4);
    }
}
