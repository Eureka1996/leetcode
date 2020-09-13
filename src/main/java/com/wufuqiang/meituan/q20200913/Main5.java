package com.wufuqiang.meituan.q20200913;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Shijian[] sjs = new Shijian[n];

		for(int i = 1;i<=n;i++){
			Shijian sj = new Shijian();
			sj.id = i;
			sj.f = sc.nextInt();
			sj.s = sc.nextInt();
			sjs[i-1] = sj;
		}
		Arrays.sort(sjs, new Comparator<Shijian>() {
			@Override
			public int compare(Shijian o1, Shijian o2) {
				if(o1.s > o2.s){
					return -1;
				}else if(o1.s < o2.s){
					return 1;
				}else{
					if(o1.f>o2.f){
						return -1;
					}else if(o1.f<o2.f){
						return 1;
					}else{
						return 0;
					}
				}
			}
		});
		for(Shijian s:sjs){
			System.out.println(s.id+" ");
		}
		sc.close();

	}
}

class Shijian{
	public int id;
	public int f;
	public int s;
}