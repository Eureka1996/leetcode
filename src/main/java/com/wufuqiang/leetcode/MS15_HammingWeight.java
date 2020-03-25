package com.wufuqiang.leetcode;

public class MS15_HammingWeight {
	public static void main(String[] args) {
		int count = hammingWeight(-9);
		System.out.println(count);
	}
	public static int hammingWeight(int n) {
		int count = 0;
		if(n<0){
			count+=1;
			int tmp = 1;
			for(int i = 0 ;i<31;i++){
				tmp<<=1;
			}
			n = n ^ tmp;
		}

		System.out.println(n);
		while(n != 0){
			if((n&1) == 1){
				count+=1;
			}
			n >>= 1;
		}
		return count;
	}
}
