package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-26 23:55
 */
public class L1679_MaxOperations {
    public static void main(String[] args) {

    }

    public int maxOperations(int[] nums, int k) {
        int low = 0;
        int high = nums.length -1;
        Arrays.sort(nums);
        int result = 0;
        int sum = 0;
        while(low < high){
            sum = nums[low] + nums[high];
            if(sum == k) {
                low++;
                high--;
                result++;
            }else if(sum < k) {
                low++;
            } else{
                high--;
            }
        }
        return sum;
    }
}
