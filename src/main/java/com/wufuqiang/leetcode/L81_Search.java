package com.wufuqiang.leetcode;

import javax.xml.stream.events.EndDocument;

/**
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
            return searchRec(nums,low+1,high,target);
        }else if(nums[low] < nums[mid]){
            if(nums[low] <= target && target < nums[mid]){
                return searchRec(nums,low,mid-1,target);
            }else{
                return searchRec(nums,mid,high,target);
            }
        }else{
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
