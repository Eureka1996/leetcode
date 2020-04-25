package com.wufuqiang.leetcode;

import java.util.Arrays;
//做菜 贪心
public class L1402_MaxSatisfaction {
	public int maxSatisfaction(int[] satisfaction) {
		Arrays.sort(satisfaction);
		int sumSatis = 0;
		int index = satisfaction.length;
		for(int i = satisfaction.length-1;i>=0;i--){
			if(sumSatis+satisfaction[i] >= 0){
				sumSatis+=satisfaction[i];
				index=i;
			}else{
				break;
			}
		}
		int result = 0;
		for(int i = index;i<satisfaction.length;i++){
			result+=((i-index+1)*satisfaction[i]);
		}
		return result;
	}
}
