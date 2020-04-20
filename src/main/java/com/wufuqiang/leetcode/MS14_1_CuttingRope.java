package com.wufuqiang.leetcode;

//剪绳子
public class MS14_1_CuttingRope {
	public int cuttingRope(int n) {
		int result = 1;
		if(n==2) return 1;
		if(n==3) return 2;
		while(n>4){
			result*=3;
			n-=3;
		}
		return result*n;
	}
}
