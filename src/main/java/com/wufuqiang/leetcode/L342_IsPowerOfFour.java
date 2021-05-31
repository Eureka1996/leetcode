package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-31 13:40
 */
public class L342_IsPowerOfFour {
    public static void main(String[] args) {

    }

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n-1))== 0  && (n & 0xaaaaaaaa) == 0;
    }
}
