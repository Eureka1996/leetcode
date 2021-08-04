package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @author: Wu Fuqiang
 * @create: 2021-08-04 21:25
 */
public class L611_TriangleNumber {
    public static void main(String[] args) {

    }

    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int left = j+1;
                int right = n-1;
                int k = j;
                while (left <= right){
                    int mid = (left+right)/2;
                    if(nums[mid] < nums[i]+nums[j]){
                        k = mid;
                        left = mid+1;
                    }else{
                        right = mid -1;
                    }
                }
                result += (k-j);
            }
        }
        return result;
    }
}
