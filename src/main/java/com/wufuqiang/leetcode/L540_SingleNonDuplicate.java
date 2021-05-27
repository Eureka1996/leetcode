package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-25 23:36
 */
public class L540_SingleNonDuplicate {
    public static void main(String[] args) {
        L540_SingleNonDuplicate l = new L540_SingleNonDuplicate();
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        nums = new int[]{3,3,7,7,10,11,11};
        System.out.println(l.singleNonDuplicate(nums));

    }
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        return partition(nums,0,nums.length-1);

    }

    public int partition(int[] nums , int low ,int high){
        if(low == high) return nums[low];
        int mid = (low+high)/2;
        int left = mid;
        int right = mid;
        if(nums[mid] == nums[mid-1]){
            left --;
        }
        if(nums[mid] == nums[mid+1]){
            right++;
        }
        if(left == right){
            return nums[mid];
        }
        if(((left-low) & 1) == 1){
            return partition(nums,low,left-1);
        }else{
            return partition(nums,right+1,high);
        }

    }
}

