package com.wufuqiang.leetcode;

public class MS59_1_MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null || nums.length == 0){
			return new int[]{0};
		}
		if(k==0){
			return new int[]{0};
		}
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int leftFirst = 0;
		for(int i = 0 ;i < nums.length;i++){
			if(i%k == 0){
				leftFirst = nums[i];
			}
			if(nums[i] > leftFirst){
				leftFirst=nums[i];
			}
			left[i] = leftFirst;
		}

		int rightFirst = 0;
		for(int i = nums.length-1;i>=0;i--){
			if(i==nums.length || (i+1)%k == 0){
				rightFirst = nums[i];
			}
			if(nums[i] > rightFirst){
				rightFirst = nums[i];
			}
			right[i]=rightFirst;
		}
		int[] result = new int[nums.length-k+1];
		for(int i = 0;i<nums.length-k+1;i++){
			result[i] = Math.max(right[i],left[i+k-1]);
		}
		return result;
	}
}
