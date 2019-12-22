package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 10:43
 **/
public class L1250_IsGoodArray {
    public boolean isGoodArray(int[] nums) {
        int len = nums.length, res = nums[0];
        for(int i = 1; i < len; i ++){
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
