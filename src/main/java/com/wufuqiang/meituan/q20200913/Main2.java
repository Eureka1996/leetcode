package com.wufuqiang.meituan.q20200913;

import java.util.Scanner;

public class Main2 {
	private static int count  = 0;

	private static int m ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		int[] grad = new int[n];

		for(int i = 0;i<n;i++){
			grad[i] = sc.nextInt();
		}
		if(n==0 || m == 0){
			System.out.println(count);
			return;
		}
		backtrack(grad,0,0,k);
		System.out.println(count);
		sc.close();
	}

	public static void backtrack(int[] grad,int start,int cur,int k){
		if(cur>=grad.length || grad.length-start+1<m) return;
		if(grad[cur] < k) {
			backtrack(grad,cur+1,cur+1,k);
		}else if(cur-start+1==m){
			count++;
			backtrack(grad,start+1,cur+1,k);
		}else{
			backtrack(grad,start,cur+1,k);
		}
	}
}
