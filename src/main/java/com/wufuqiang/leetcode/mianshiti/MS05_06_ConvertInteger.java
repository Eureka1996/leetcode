package com.wufuqiang.leetcode.mianshiti;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-16 00:35
 */
public class MS05_06_ConvertInteger {
    public static void main(String[] args) {

    }
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A^B);
    }
}
