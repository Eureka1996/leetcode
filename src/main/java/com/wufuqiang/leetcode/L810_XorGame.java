package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-22 10:23
 */
public class L810_XorGame {
    public static void main(String[] args) {

    }
    public boolean xorGame(int[] nums) {
        if((nums.length & 1) == 0) return true;
        int result = 0;
        for(int n : nums) result^=n;
        return result == 0;
    }
}
