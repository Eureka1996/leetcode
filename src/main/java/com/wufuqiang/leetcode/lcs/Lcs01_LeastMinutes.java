package com.wufuqiang.leetcode.lcs;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-21 21:21
 */
public class Lcs01_LeastMinutes {
    public int leastMinutes(int n) {
        int speed = 1;
        int res = 0;
        while(speed < n){
            speed <<= 1;
            res += 1;
        }
        res+=1;
        return res;
    }
}
