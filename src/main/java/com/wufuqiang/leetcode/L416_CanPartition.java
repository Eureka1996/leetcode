package com.wufuqiang.leetcode;

public class L416_CanPartition {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for(int n : nums) sum+=n;
		//如果是奇数，肯定无法平分
		if((sum &1) == 1) return false;
		sum /=2;

		

		return false;
	}
}
