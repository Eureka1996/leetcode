package com.wufuqiang.leetcode;

public class MS05_03_ReverseBits {
	public int reverseBits(int num) {

		int preCount = 0;
		int nextCount = 0;
		boolean flag = true;
		int result = 0;

		while(num>0){
			if((num&1) == 1){
				nextCount+=1;
			}else{
				result = Math.max(result,nextCount+preCount+1);
				preCount=nextCount;
				nextCount=0;

			}
			num>>=1;
		}
		result = Math.max(result,nextCount+preCount+1);
		return result;
	}
}
