package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//三数之和
public class L15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            if(nums[i] > 0) break;
            if(i>1 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left] == nums[left+1]) left+=1;
                    while(left < right && nums[right-1] == nums[right]) right-=1;
                    left+=1;
                    right-=1;
                }else if(sum<0){
                    left+=1;
                }else if(sum>0){
                    right-=1;
                }
            }
        }
        return result;
    }
}
