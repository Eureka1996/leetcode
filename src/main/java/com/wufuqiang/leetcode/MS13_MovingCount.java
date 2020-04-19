package com.wufuqiang.leetcode;

import java.util.*;

public class MS13_MovingCount {
	public static void main(String[] args) {
		MS13_MovingCount ms13 = new MS13_MovingCount();
		int i = ms13.movingCount(3, 2, 17);
		System.out.println(i);
	}
	public int movingCount(int m, int n, int k) {
		int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
		int result = 0;

		Set<List<Integer>> vidited = new HashSet<>();
		LinkedList<List<Integer>> queue = new LinkedList<>();
		List<Integer> first = Arrays.asList(0,0);
		queue.offerLast(first);
		vidited.add(first);
		while(!queue.isEmpty()){
			List<Integer> l = queue.pollFirst();
			result+=1;
//			System.out.println(l.get(0)+","+l.get(1));
			for(int i = 0;i<4;i++){
				int row = l.get(0) + directions[i][0];
				int column = l.get(1) + directions[i][1];
				List<Integer> vt = Arrays.asList(row,column);
				if(row >= 0 && row < m &&
				   column >= 0 && column < n &&
				   !vidited.contains(vt) && getSum(row) + getSum(column) <= k){
//					System.out.println(row+","+column);
					vidited.add(vt);
					queue.offerLast(vt);
				}
			}
		}


		return result;
	}
	public int getSum(int num){
		int sum = 0;
		while(num>0){
			sum += (num%10);
			num/=10;
		}
		return sum;
	}
}
