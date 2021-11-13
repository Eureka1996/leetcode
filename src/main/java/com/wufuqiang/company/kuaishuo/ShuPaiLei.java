package com.wufuqiang.company.kuaishuo;

import java.util.Scanner;

public class ShuPaiLei {
	private static int result = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		dfs(n,0,0);
		System.out.print(result);
	}

	public static void dfs(int n ,int l,int r){
		if(r>l || l > n || r >n) return;

		if(l==n && r == n){
			result+=1;
			return;
		}
		dfs(n,l+1,r);
		dfs(n,l,r+1);

	}

}
