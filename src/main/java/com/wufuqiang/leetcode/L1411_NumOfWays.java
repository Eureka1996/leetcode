package com.wufuqiang.leetcode;
//涂色 N*3
public class L1411_NumOfWays {
	public int numOfWays(int n) {
		int result = 0;
		long type0 = 6;
		long type1 = 6;
		int mod = (int)1e9+7;
		for(int i = 2;i<=n;i++){
			long newType0 = (2l*type0+2l*type1) % mod;
			long newType1 = (2l*type0+3l*type1) % mod;
			type0 = newType0;
			type1 = newType1;
		}
		return (int)((type0+type1)%mod);
	}
}
