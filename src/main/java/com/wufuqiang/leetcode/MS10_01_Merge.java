package com.wufuqiang.leetcode;

public class MS10_01_Merge {
	public void merge(int[] A, int m, int[] B, int n) {
		int height = m+n-1;
		int ai = m-1;
		int bi = n-1;
		while(ai>=0 && bi>=0){
			if(A[ai]>B[bi]){
				A[height] = A[ai];
				ai-=1;
				height-=1;
			}else{
				A[height] = B[bi];
				height-=1;
				bi-=1;
			}
		}
		while(bi>=0){
			A[height] = B[bi];
			height-=1;
			bi-=1;
		}
	}
}
