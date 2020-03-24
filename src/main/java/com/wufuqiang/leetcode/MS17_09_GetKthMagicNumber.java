package com.wufuqiang.leetcode;

public class MS17_09_GetKthMagicNumber {
	public int getKthMagicNumber(int k) {
		if(k<=0){
			return 0;
		}
		if(k == 1){
			return 1;
		}
		int index3 = 0;
		int index5 = 0;
		int index7 = 0;
		int[] result = new int[k];
		result[0] = 1;
		for(int i = 1;i<k;i++){
			int num3 = result[index3] * 3;
			int num5 = result[index5] * 5;
			int num7 = result[index7] * 7;
			int min = Math.min(Math.min(num3, num5), num7);
			result[i] = min;
			if(num3 == min){
				index3+=1;
			}
			if(num5 == min){
				index5+=1;
			}
			if(num7 == min){
				index7+=1;
			}
		}

		return result[k-1];
	}
}
