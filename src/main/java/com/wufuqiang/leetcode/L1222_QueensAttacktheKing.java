package com.wufuqiang.leetcode;

import java.util.*;

public class L1222_QueensAttacktheKing {
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		int row  = king[0];
		int column = king[1];
		Set<List<Integer>> set = new HashSet<>();
		for(int[] q : queens){
			if(row<q[0]) row = q[0];
			if(column<q[1]) column = q[1];
			set.add(Arrays.asList(q[0],q[1]));
		}
		List<List<Integer>> result = new ArrayList<>();
		for(int i = king[0];i>=0;i--){
			List<Integer> q = Arrays.asList(i,king[1]);
			if(set.contains(q))  {
				result.add(q);
				break;
			}
		}
		for(int i = king[0];i<=column;i++){
			List<Integer> q = Arrays.asList(i,king[1]);
			if(set.contains(q)) {
				result.add(q);
				break;
			}
		}
		for(int i = king[1];i>=0;i--){
			List<Integer> q = Arrays.asList(king[0],i);
			if(set.contains(q)) {
				result.add(q);
				break;
			}
		}
		for(int i = king[1];i<=column;i++){
			List<Integer> q = Arrays.asList(king[0],i);
			if(set.contains(q)) {
				result.add(q);
				break;
			}
		}
		for(int i = king[0],j = king[1];i>=0 && j>=0;i--,j--){
			List<Integer> q = Arrays.asList(i,j);
			if(set.contains(q))  {
				result.add(q);
				break;
			}
		}
		for(int i = king[0],j = king[1];i<=row && j<=column;i++,j++){
			List<Integer> q = Arrays.asList(i,j);
			if(set.contains(q))  {
				result.add(q);
				break;
			}
		}
		for(int i = king[0],j = king[1];i>=0 && j<=column;i--,j++){
			List<Integer> q = Arrays.asList(i,j);
			if(set.contains(q))  {
				result.add(q);
				break;
			}
		}
		for(int i = king[0],j = king[1];i<=row && j>=0;i++,j--){
			List<Integer> q = Arrays.asList(i,j);
			if(set.contains(q))  {
				result.add(q);
				break;
			}
		}
		return result;
	}
}
