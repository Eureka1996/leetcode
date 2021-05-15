package com.wufuqiang.leetcode.jianzhioffer;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-15 10:13
 */
public class O57_TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int result  = 0;
        boolean flag = false;
        while(low < high){
            result = nums[low] + nums[high];
            if(result == target){
                flag = true;
                break;
            }else if(target < result){
                high--;
            }else{
                low++;
            }
        }
        if(flag){
            return new int[]{nums[low],nums[high]};
        }else {
            return new int[]{};
        }
    }

}
