package com.wufuqiang.leetcode;

public class MS08_01_WaysToStep {

	public static void main(String[] args) {
		MS08_01_WaysToStep ms08 = new MS08_01_WaysToStep();
		int i = ms08.waysToStep(61);
		System.out.println(Integer.MAX_VALUE*1.0/1000000007);
		System.out.println(i);
	}
	public int waysToStep(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for(int i = 3;i<n;i++){
			dp[i] = ((dp[i-1] + dp[i-2])%(1000000007) + dp[i-3])%(1000000007);
		}

//		752119970

		return dp[n-1];
	}
}
