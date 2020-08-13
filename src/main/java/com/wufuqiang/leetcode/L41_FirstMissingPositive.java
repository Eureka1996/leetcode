package com.wufuqiang.leetcode;

/**
 * 缺失的第一个正数
 */
public class L41_FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		int tmp = 0;
		for(int i = 0;i<n;i++){
			while(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]){
				tmp = nums[i];
				nums[i] = nums[nums[i]-1];
				nums[nums[i]-1] = tmp;
			}
		}
		for(int i = 0;i<n;i++){
			if(i != nums[i]-1){
				return i+1;
			}
		}
		return n+1;
	}
}
