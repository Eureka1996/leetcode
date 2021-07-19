package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-20 00:57
 */
public class L1877_MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0;i<nums.length/2;i++){
            res = Math.max(res,nums[i] + nums[nums.length-i-1]);
        }
        return res;
    }
}
