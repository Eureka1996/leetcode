package com.wufuqiang.leetcode;

public class L713_NumSubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int left = 0;
		int right = 0;
		int sum = 1;
		while(right < nums.length){
			if (sum * nums[right] < k) {

			}
		}
		return left;

	}
}
