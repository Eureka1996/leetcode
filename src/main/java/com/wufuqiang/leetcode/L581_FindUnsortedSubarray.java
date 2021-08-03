package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-08-03 23:11
 */
public class L581_FindUnsortedSubarray {
    public static void main(String[] args) {

    }

    public int findUnsortedSubarray(int[] nums) {
        int maxLeft = Integer.MIN_VALUE;
        int right = -1;
        int minRight = Integer.MAX_VALUE;
        int left = -1;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(maxLeft > nums[i]) right = i;
            else maxLeft = nums[i];
            if(minRight < nums[n-i-1]) left = n-i-1;
            else minRight = nums[n-i-1];
        }
        return right == -1 ? 0 :right - left +1;
    }
}
