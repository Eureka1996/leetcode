package com.wufuqiang.leetcode;

import javax.xml.stream.events.EndDocument;

/**
 *  搜索旋转排序数组 II
 * @ author wufuqiang
 **/
public class L81_Search {

    public boolean searchRec(int[] nums,int low,int high,int target){
        if(low>high){
            return false;
        }
        if(target == nums[(low+high)/2]){
            return true;
        }
        int mid = (low+high)/2;
        if(nums[low] == nums[mid]){
            //nums[low] == nums[mid]无法判断转折点在那一边，但low这个位置肯定不是目标值
            return searchRec(nums,low+1,high,target);
        }else if(nums[low] < nums[mid]){
            //若nums[low] < nums[mid]，则左边是有序的，转折点在右边
            if(nums[low] <= target && target < nums[mid]){
                return searchRec(nums,low,mid-1,target);
            }else{
                return searchRec(nums,mid,high,target);
            }
        }else{
            //右边是有序的，转折点在左边
            if(nums[mid] < target && target <= nums[high]){
                return searchRec(nums,mid+1,high,target);
            }else{
                return searchRec(nums,low,mid,target);
            }
        }
    }

    public boolean search(int[] nums, int target) {
        return searchRec(nums,0,nums.length-1,target);
    }
}
