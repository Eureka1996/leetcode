package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-27 00:29
 */
public class L461_HammingDistance {
    public static void main(String[] args) {

    }
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int result = 0;
        while(xor > 0){
            if((xor & 1) == 1){
                result++;
            }
            xor >>= 1;
        }
        return result;
    }
}
