package com.wufuqiang.leetcode;

public class MS49_NthUglyNumber {
	public static void main(String[] args) {
		MS49_NthUglyNumber ms49 = new MS49_NthUglyNumber();
		int r = ms49.nthUglyNumber(10);
		System.out.println(r);
	}
	public int nthUglyNumber(int n) {
		if(n<=0) return 0;
		int[] result = new int[n];
		result[0] = 1;
		int base2i = 0;
		int base3i = 0;
		int base5i = 0;
		for(int i = 1;i<n;i++){
			int a = result[base2i] * 2;
			int b = result[base3i] * 3;
			int c = result[base5i] * 5;
			result[i] = Math.min(Math.min(a,b),c);
			if(a==result[i]) base2i+=1;
			if(b==result[i]) base3i += 1;
			if(c==result[i]) base5i += 1;
		}
		return result[n-1];
	}
}
