package com.wufuqiang.leetcode;

public class L1295_FindNumbers {
	public int findNumbers(int[] nums) {
		int count = 0;
		for(int n : nums){
			int c = 0;
			while(n>0){
				c+=1;
				n/=10;
			}
			if(c%2==0){
				count+=1;
			}
		}

		return count;
	}
}
