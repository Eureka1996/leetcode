package com.wufuqiang.leetcode.jianzhioffer;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-17 00:46
 */
public class O42_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for(int i =1;i<nums.length;i++){
            nums[i] = nums[i] + Math.max(nums[i-1],0);
            result = Math.max(result,nums[i]);
        }
        return result;
    }
}
