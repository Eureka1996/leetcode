package com.wufuqiang.leetcode;

//剪绳子
public class MS14_2_CuttingRope {
	public int cuttingRope(int n) {

		if(n==2) return 1;
		if(n==3) return 2;
		long result = 1;
		int mod = (int)1e9+7;
		while(n>4){
			result*=3;
			result%=mod;
			n-=3;
		}
		return (int)(result*n%mod);
	}
}
