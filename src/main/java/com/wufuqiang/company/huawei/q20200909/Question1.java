package com.wufuqiang.company.huawei.q20200909;

import java.util.Scanner;

public class Question1 {
	private static int len = 0;
	private static int[] d = {1,0,-1,0,1};

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] iland = new int[r][c];
		for(int i = 0 ;i<r;i++){
			for(int j = 0;j<c;j++){
				iland[i][j] = sc.nextInt();
			}
		}


		sc.close();
	}

	public static void shuigou(int r,int c,int[][] iland){


	}

	public static void backtrack(int r,int c,int[][] iland,boolean[][] flag,int i,int j,int l){
		if(i>=0 && i<r && j>=0 && j<c){
			int ni = i;
			int nj = j;
			for(int k=0;k<4;k++){
				ni = i+d[k];
				nj = j+d[k+1];
			}




		}else{
			len = Math.max(len,l-1);
		}
	}
}
