package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @ author wufuqiang
 **/
public class L239_MaxSlidingWindow {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0},4);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] left = new int[nums.length];
        if(nums.length * k == 0){
            return new int[0];
        }
        if(k == 1){
            return nums;
        }
        for(int i = 0;i<nums.length;i++){
            if(i%k == 0){
                left[i] = nums[i];
            }else{
                left[i] = Math.max(left[i-1],nums[i]);
            }

        }

        int[] right = new int[nums.length];
        for(int i = nums.length-1;i>=0;i--){
            int index = Math.min(i/k*k+k-1,nums.length-1);
            if(i==index){
                right[i] = nums[i];
            }else{
                right[i] = Math.max(nums[i],right[i+1]);
            }
        }
        int[] result = new int[nums.length-k+1];
        for(int i = 0 ; i < nums.length - k + 1 ; i++){
            int j = i + k -1;
            int maxRange = Math.max(right[i],left[j]);
            result[i] = maxRange;
        }
        return result;
    }
}
