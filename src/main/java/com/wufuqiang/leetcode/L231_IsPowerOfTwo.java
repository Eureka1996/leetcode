package com.wufuqiang.leetcode;

public class L231_IsPowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if(n<=0){
			return false;
		}
		boolean flag = true;
		while(n>1){
			if((n&1) == 1){
				flag = false;
				break;
			}
			n>>=1;
		}
		if(n==0){
			flag = false;
		}
		return flag;
	}
}
