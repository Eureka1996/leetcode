package com.wufuqiang.leetcode;

public class L746_MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		int result = 0;
		for(int i = 2; i<cost.length;i++){
			cost[i] += Math.min(cost[i-1],cost[i-2]);
		}
		result = Math.min(cost[cost.length-1],cost[cost.length-2]);
		return result;
	}
}
