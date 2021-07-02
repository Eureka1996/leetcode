package com.wufuqiang.leetcode.mianshiti;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-02 16:25
 */
public class MS08_03_FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums,0,nums.length-1);
    }

    public int getAnswer(int[] nums,int low,int high){
        if(low > high) return -1;
        int mid = (high-low)/2 + low;
        int leftAnswer = getAnswer(nums,low,mid-1);
        if(leftAnswer != -1) return leftAnswer;
        else if(nums[mid] == mid) return mid;
        return getAnswer(nums,mid+1,high);
    }
}
