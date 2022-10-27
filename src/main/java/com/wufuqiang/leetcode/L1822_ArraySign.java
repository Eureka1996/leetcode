package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2022-10-27 09:05
 *
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 *
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 *
 * 返回 signFunc(product) 。
 *
 */
public class L1822_ArraySign {
    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        int zeroCnt = 0;
        int minusCnt = 0;
        for(int n: nums){
            if(n < 0 ){
                minusCnt+=1;
            }else if(n == 0){
                return 0;
            }
        }
        if( (minusCnt & 1) == 1){
            return -1;
        }else{
            return 1;
        }
    }
}
