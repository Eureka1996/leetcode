package com.wufuqiang.leetcode;

public class L172_TrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n>0){
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
