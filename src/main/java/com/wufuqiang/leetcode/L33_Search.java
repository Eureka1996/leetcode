package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 **/
public class L33_Search {

    public int searchRec(int[] nums,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(target == nums[mid]){
            return mid;
        }
        if(nums[low] <= nums[mid]){
            if(nums[low] <= target && target < nums[mid]){
                return searchRec(nums,low,mid-1,target);
            }else{
                return searchRec(nums,mid+1,high,target);
            }
        }else{
            if(nums[mid] < target && target <= nums[high]){
                return searchRec(nums,mid+1,high,target);
            }else{
                return searchRec(nums,low,mid-1,target);
            }
        }
    }

    public int search(int[] nums, int target) {
        return searchRec(nums,0,nums.length-1,target);
    }

    public static void main(String[] args) {
        L33_Search l = new L33_Search();
        System.out.println(l.search(new int[]{3,1},1));
    }
}
