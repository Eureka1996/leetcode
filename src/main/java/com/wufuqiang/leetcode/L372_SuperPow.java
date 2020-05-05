package com.wufuqiang.leetcode;
//超级次方
public class L372_SuperPow {
	public int superPow(int a, int[] b) {
		int mod = 1337;

		long first = 0;
		long firstMod = 1;
		long second = 0;
		for(int bt:b){
			second = fastExpMod(firstMod,10,mod);
			first = fastExpMod(a,bt,mod);
			firstMod = (second*first)%mod;

		}
		return (int)firstMod;

	}

	public static long fastExpMod(long b,long e,int mod){
		long result = 1;
		double tmp = 0;
		while(e != 0){
			if((e&1) == 1){
				tmp = 1.0*result*b;
				result = (long)(tmp%mod);
			}
			e>>=1;
			tmp = 1.0*b*b;
			b = (long)(tmp%mod);
		}
		return result;
	}
}
