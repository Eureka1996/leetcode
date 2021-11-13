package com.wufuqiang.company.kuaishuo;

import java.util.Scanner;

public class Component {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		calc(m,n);

	}
	public static void calc(int m ,int n){
		int min = Math.min(n,m-n);
		int max = Math.max(n,m-n);
		int a = 1;
		for(int i = 1;i<=min;i++) {
			System.out.println("i:"+i);
			a = (a*(i%3))%3;
		}
		for(int i = max+1;i<=m;i++){
			System.out.println("j:"+i);
			a = (a*(i%3))%3;
		}
		System.out.print(a);
	}
}
