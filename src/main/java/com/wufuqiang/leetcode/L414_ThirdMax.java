package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 **/
public class L414_ThirdMax {

    public int thirdMax(int[] nums) {
        long[] result = new long[]{Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE};
        int count = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] > result[0]){
                count+=1;
                result[2] = result[1];
                result[1] = result[0];
                result[0] = nums[i];
            }else if(nums[i] < result[0] && nums[i] > result[1]){
                count+=1;
                result[2] = result[1];
                result[1] = nums[i];
            }else if(nums[i] < result[1] && nums[i] > result[2]){
                count+=1;
                result[2] = nums[i];
            }
        }
        if(count < 3){
            return (int)result[0];
        }else{
            return (int)result[2];
        }

    }
}
