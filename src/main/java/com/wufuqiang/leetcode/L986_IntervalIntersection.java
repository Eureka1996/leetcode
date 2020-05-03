package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//区间列表的交集
public class L986_IntervalIntersection {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		int aindex = 0;
		int bindex = 0;
		List<int[]> res = new ArrayList<>();
		while(aindex<A.length && bindex < B.length){
			int left = Math.max(A[aindex][0],B[bindex][0]);
			int right = Math.min(A[aindex][1],B[bindex][1]);
			if(left <= right){
				res.add(new int[]{left,right});
			}
			if(A[aindex][1] < B[bindex][1]){
				aindex+=1;
			}else{
				bindex+=1;
			}
		}
		return res.toArray(new int[res.size()][]);
	}
}
