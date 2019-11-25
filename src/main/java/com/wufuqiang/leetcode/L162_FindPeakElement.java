package com.wufuqiang.leetcode;

public class L162_FindPeakElement {

    public static int findPeakElementRec(int[] nums,int low,int high){
        if(low == high){
            return low;
        }

        int mid = (low+high)/2;

        if(nums[mid]>nums[mid+1]){
            return findPeakElementRec(nums,low,mid);
        }
        return findPeakElementRec(nums,mid+1,high);


    }

    public int findPeakElement(int[] nums) {
        return findPeakElementRec(nums,0,nums.length-1);
    }
}
