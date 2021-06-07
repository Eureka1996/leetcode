package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-07 13:40
 */
public class L494_FindTargetSumWays {
//    private int sum = 0;
    private int count = 0;

    public static void main(String[] args) {

    }
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,0,target,0);
        return count;
    }

    public void backtrack(int[] nums,int index,int target,int sum){
        if(nums.length <= index) {
            if(sum == target) count+=1;
            return;
        }
        backtrack(nums,index+1,target,sum+nums[index]);
        backtrack(nums,index+1,target,sum-nums[index]);
    }


}
