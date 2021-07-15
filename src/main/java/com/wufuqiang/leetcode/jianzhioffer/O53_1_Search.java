package com.wufuqiang.leetcode.jianzhioffer;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-16 00:16
 */
public class O53_1_Search {
    public int search(int[] nums, int target) {
        int left = binarySearch(nums,target,true);
        int right = binarySearch(nums,target,false)-1;
        if(left <= right && right < nums.length && nums[left] == target && nums[right] == target){
            return right - left +1 ;
        }
        return 0;
    }

    private int binarySearch(int[] nums,int target,boolean lower){
        int left = 0;
        int right = nums.length -1;
        int ans = nums.length;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
