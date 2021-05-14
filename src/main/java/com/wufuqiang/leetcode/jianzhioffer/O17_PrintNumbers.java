package com.wufuqiang.leetcode.jianzhioffer;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-14 19:38
 */
public class O17_PrintNumbers {
    public static void main(String[] args) {

    }
    public int[] printNumbers(int n) {
        int count = (int)Math.pow(10,n)-1;
        int[] result = new int[count];
        for(int i = 0;i<count;i++){
            result[i] = i+1;
        }
        return result;
    }
}
