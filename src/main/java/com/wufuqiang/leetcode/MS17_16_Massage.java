package com.wufuqiang.leetcode;

public class MS17_16_Massage {
	public int massage(int[] nums) {
		if(nums==null || nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		if(nums.length == 2){
			return Math.max(nums[0],nums[1]);
		}

		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		sum[1] = Math.max(nums[0],nums[1]);
		for(int i = 2; i< nums.length;i++){
			int sumTime1 = sum[i-1];
			int sumTIme2 = sum[i-2]+nums[i];
			sum[i] = Math.max(sumTime1,sumTIme2);
		}
		return sum[nums.length-1];
	}
}
