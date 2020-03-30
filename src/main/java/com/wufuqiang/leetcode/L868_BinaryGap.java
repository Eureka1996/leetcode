package com.wufuqiang.leetcode;

public class L868_BinaryGap {
	public int binaryGap(int N) {
		int result = 0;
		boolean flag = false;
		int stepCount = 0;
		while(N>0){
			if((N&1)==1){
				if(!flag){
					stepCount=1;
					flag=true;
				}else{
					if(stepCount>result){
						result = stepCount;
					}
					flag = false;
				}
			}
			if(flag){
				stepCount+=1;
			}
			N>>=1;
		}
		return result;
	}
}
