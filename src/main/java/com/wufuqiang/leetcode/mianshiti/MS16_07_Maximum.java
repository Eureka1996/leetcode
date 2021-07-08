package com.wufuqiang.leetcode.mianshiti;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-09 00:20
 */
public class MS16_07_Maximum {
    public int maximum(int a, int b) {
        return (a+b+Math.abs(a-b))/2;
    }
}
