package com.wufuqiang.leetcode;

public class L213_Rob {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int maxRob1 = getMaxRob(nums,0,nums.length-2);
        int maxRob2 = getMaxRob(nums,1,nums.length-1);
        return Math.max(maxRob1,maxRob2);
    }
    public int getMaxRob(int[] nums,int low,int hight) {
        if (hight < low) {
            return 0;
        }
        if (low == hight) {
            return nums[low];
        }
        if (low == hight - 1) {
            return Math.max(nums[low], nums[low + 1]);
        }
        int[] dp = new int[hight - low + 1];
        dp[0] = nums[low];
        dp[1] = Math.max(nums[low], nums[low + 1]);
        for (int i = low + 2; i <= hight; i++) {
            dp[i - low] = Math.max(dp[i - low - 1], dp[i - low - 2] + nums[i]);
        }
        return dp[hight - low];
    }
}
