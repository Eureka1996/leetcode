package com.wufuqiang.leetcode;

public class L945_MinIncrementForUnique {
	public int minIncrementForUnique(int[] A) {
		int[] tmp = new int[80000];
		for(int a : A){
			tmp[a]+=1;
		}
		int increment = 0;
		int needIncrementCount = 0;

		for(int i = 0 ;i < 80000;i++){
			if(tmp[i]>=2){
				needIncrementCount += (tmp[i]-1);
				increment -= (i * (tmp[i]-1));
			}else if(needIncrementCount>0 && tmp[i] == 0){
				needIncrementCount-=1;
				increment+=i;
			}
		}

		return increment;
	}
}
