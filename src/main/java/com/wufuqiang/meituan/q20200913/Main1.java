package com.wufuqiang.meituan.q20200913;

import java.util.Scanner;

public class Main1 {
	private static int[] nums = null;
	private static int res = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] grid = new int[n][m];
		nums = new int[n];
		res = n-1;
		for(int i =0;i<n;i++){
			int sum = 0;
			for(int j = 0;j<m;j++){
				grid[i][j] = sc.nextInt();
				sum = sum*10+grid[i][j];
			}
			nums[i] = sum;
		}

		findRec(grid,0,n-1);

		for(int i = 0;i<=res;i++){
			for(int j = 0;j<m;j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}

		sc.close();
	}

	public static void findRec(int[][] grid,int start,int end){
		int mid = (start+end)/2;
		int startTmp = start;
		int endTmp = end;
		boolean flag = true;
		while(startTmp <= mid){
			if(nums[startTmp] == nums[endTmp]){
				startTmp+=1;
				endTmp-=1;
			}else{
				flag = false;
				break;
			}
		}
		if(flag){
			findRec(grid,start,mid);
		}else{
			res = Math.min(res,end);
		}


	}
}
