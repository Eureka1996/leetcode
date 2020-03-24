package com.wufuqiang.leetcode;

public class L397_IntegerReplacement {
	public int integerReplacement(int n) {
		int count = 0;
		while(n>1){
			if(n == 3){
				n -= 1;
			}else if(n % 4 == 1){
				n -= 1;
			}else if(n % 4 == 3){
				n += 1;
			}else{
				n /= 2;
			}
			count+=1;
		}
		return count;
	}
}
