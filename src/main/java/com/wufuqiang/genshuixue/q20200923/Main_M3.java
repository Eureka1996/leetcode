package com.wufuqiang.genshuixue.q20200923;

import java.util.Scanner;

public class Main_M3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a =0;
		while(a<5){
			switch (a){
				case 0:
				case 3: a = a+2;
				case 1:
				case 2: a = a+3;
				default:a=a+5;
			}


		}
		System.out.println(a);


		sc.close();
	}
}
