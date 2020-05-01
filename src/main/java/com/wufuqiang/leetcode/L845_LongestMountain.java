package com.wufuqiang.leetcode;
//最长山脉
public class L845_LongestMountain {
	public int longestMountain(int[] A) {
		int ans = 0;
		int base = 0;
		int len = A.length;
		while(base < len){
			int end = base;
			if(end+1<len && A[end] < A[end+1]){
				while(end+1<len && A[end] < A[end+1]) end+=1;
				if(end+1 < len && A[end]>A[end+1]){
					while(end+1 < len && A[end]>A[end+1]) end+=1;
					ans = Math.max(ans,end-base+1);
				}
			}

			base = Math.max(end,base+1);
		}

		return ans;
	}
}
