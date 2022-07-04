package com.wufuqiang.company.beike.q20201026;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		if(T == 0){
			return;
		}
		int x=0,y=0,z=0;
		int a=0,b=0,c=0;
		for(int i = 0;i<T;i++){
			x = sc.nextInt();
			y = sc.nextInt();
			z = sc.nextInt();
			a = Math.min(x,y);
			b = Math.min(x,z);
			c = Math.min(y,z);
			if(x == Math.max(a,b) && y == Math.max(a,c) && z == Math.max(b,c)){
				System.out.println("YES");
				System.out.println(a+" "+b+" " + c);
			}else{
				System.out.println("NO");
			}

		}
		sc.close();
	}


}
