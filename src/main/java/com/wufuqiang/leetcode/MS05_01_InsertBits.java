package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-11 22:09
 */
public class MS05_01_InsertBits {
    public static void main(String[] args) {

    }

    public int insertBits(int N, int M, int i, int j) {

        int mark = ((1<<(j-i+1))-1)<<i;
        mark = ~mark;
        N = N & mark;
        M = M<<i;
        return N | M;
    }

}
