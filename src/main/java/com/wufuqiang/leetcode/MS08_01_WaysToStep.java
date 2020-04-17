package com.wufuqiang.leetcode;

public class MS08_01_WaysToStep {

	public static void main(String[] args) {
		MS08_01_WaysToStep ms08 = new MS08_01_WaysToStep();
		int i = ms08.waysToStep(3);
		System.out.println(i);
	}
	public int waysToStep(int n) {
		int[] dp = new int[n+3];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3;i<n+3;i++){
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}

		return dp[n+2];
	}
}
