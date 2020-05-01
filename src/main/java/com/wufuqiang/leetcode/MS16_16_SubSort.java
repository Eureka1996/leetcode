package com.wufuqiang.leetcode;
//需要排序的最小范围
public class MS16_16_SubSort {
	public int[] subSort(int[] array) {
		if(array == null || array.length == 0) return new int[]{-1,-1};
		int last = -1;
		int first = -1;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int len = array.length;
		for(int i = 0;i<len;i++){
			if(array[i] < max){
				last = i;
			}else{
				max = Math.max(max,array[i]);
			}
			if(array[len-1-i] > min){
				first = len-1-i;
			}else{
				min = Math.min(min,array[len-1-i]);
			}
		}

		return new int[]{first,last};
	}
}
