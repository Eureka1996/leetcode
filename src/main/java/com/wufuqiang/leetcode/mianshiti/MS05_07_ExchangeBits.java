package com.wufuqiang.leetcode.mianshiti;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-22 01:22
 */
public class MS05_07_ExchangeBits {
    public static void main(String[] args) {

    }
    public int exchangeBits(int num) {
        int mask = 0;
        for(int i=0;i<32;i=i+2){
            mask = (mask<<2)+1;
        }
        return ((num & mask)<<1) | ((num &(mask<<1))>>1);
    }
}
