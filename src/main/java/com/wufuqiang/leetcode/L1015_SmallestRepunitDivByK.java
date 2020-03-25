package com.wufuqiang.leetcode;

public class L1015_SmallestRepunitDivByK {
	public int smallestRepunitDivByK(int K) {
		if(K % 2 == 0 || K % 5 == 0){
			return -1;
		}
		int tmp = 1;
		int count = 1;
		while(tmp % K != 0){
			tmp %= K;
			tmp = tmp * 10 +1;
			count+=1;
		}

		return count;
	}
}
