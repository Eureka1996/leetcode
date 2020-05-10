package com.wufuqiang.leetcode;

import java.util.Arrays;
//最接近的三数这和
public class L16_ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int result = 0;
		int distance = Integer.MAX_VALUE;
		if(nums == null && nums.length < 3) return Integer.MAX_VALUE;
		Arrays.sort(nums);
		for(int i = 0;i<nums.length-2;i++){
			int left = i+1;
			int right = nums.length-1;
			while(left<right){
				int sum = nums[i] + nums[left] + nums[right];
				if(Math.abs(sum-target) < distance) result = sum;
				if(sum==target){
					return result;
				}else if(sum > target){
					right-=1;
				}else if(sum < target){
					left+=1;
				}
			}
		}
		return result;
	}
}
