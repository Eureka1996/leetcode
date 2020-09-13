package com.wufuqiang.meituan.q20200913;

import java.util.Scanner;

public class Main3 {
	private static int n = 0;
	private static int k = 0;
	private static int d = 0;
	private static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		d = sc.nextInt();
		backtrack(n,0,false);
		System.out.println(result);
		sc.close();
	}

	private static void backtrack(int nn,int cur,boolean flag){
		if(cur == nn && flag){
			result++;
			return;
		}else if(cur >= nn){
			return;
		}

		for(int i = 1;i<=k;i++){
			cur +=i;
			if(i>=d){
				backtrack(nn,cur,true);
			}else{
				backtrack(nn,cur,flag);
			}
			cur-=i;
		}
	}
}
