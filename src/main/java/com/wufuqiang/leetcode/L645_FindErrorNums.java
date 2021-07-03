package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-04 00:38
 */
public class L645_FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        int missing = -1;
        for(int num : nums){
            if(nums[Math.abs(num)-1] < 0){
                dup = Math.abs(num);
            }else{
                nums[Math.abs(num) -1] *= -1;
            }
        }
        for(int i = 0 ;i < nums.length;i++){
            if(nums[i] > 0) missing = i+1;
        }
        return  new int[]{dup,missing};
    }
}
