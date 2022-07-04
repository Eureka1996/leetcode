package com.wufuqiang.company.huawei.q20201125;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		if(m == 0 || n == 0){
			System.out.println(0);
			return;
		}
		int[][] grid = new int[m][n];
		boolean[][] used = new boolean[m][n];
		for(int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				grid[i][j] = sc.nextInt();
			}
		}

		LinkedList<Integer> q = new LinkedList<>();
		int max = 0;
		int sum = 0;
		int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
		for(int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				sum = 0;
				if(q.isEmpty() && used[i][j] == false){
					q.offerLast(i);
					q.offerLast(j);
					used[i][j] =true;
					sum++;
				}
				while(!q.isEmpty()){
					int oi = q.pollFirst();
					int oj = q.pollFirst();
					for(int[] d : direction){
						int ni = oi + d[0];
						int nj = oj + d[1];
						if(ni >= 0 && ni < m && nj >= 0 && nj < n && used[ni][nj] ==false && Math.abs(grid[ni][nj] - grid[oi][oj]) <= 2){
							used[ni][nj]= true;
							sum++;
							q.offerLast(ni);
							q.offerLast(nj);
						}
					}
				}
				if(sum > max){
					max = sum;
				}

			}
		}


		System.out.println(max);

		sc.close();
	}
}
