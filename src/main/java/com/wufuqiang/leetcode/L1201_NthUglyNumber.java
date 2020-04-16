package com.wufuqiang.leetcode;

public class L1201_NthUglyNumber {
	public int nthUglyNumber(int n, int a, int b, int c) {
		int[] nums = new int[n+1];
		nums[0] = 1;
		int pa = 0;
		int pb = 0;
		int pc = 0;
		for(int i = 1;i<n+1;i++){
			int ta = nums[pa]*a;
			int tb = nums[pb]*b;
			int tc = nums[pc]*c;
			nums[i] = Math.min(Math.min(ta,tb),tc);
			if(nums[i] == ta){
				pa+=1;
			}
			if(nums[i] == tb){
				pb+=1;
			}
			if(nums[i] == tc){
				pc+=1;
			}
		}

		return nums[n];
	}
}
