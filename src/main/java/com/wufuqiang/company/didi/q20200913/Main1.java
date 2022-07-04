package com.wufuqiang.company.didi.q20200913;

import java.util.Scanner;

public class Main1 {
	private static int n = 0;
	private static int m = 0;
	private static int k = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0){
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			boolean[] flag = new boolean[n+1] ;
			int count = 0;
			int fid = 0;
			int sid = 0;
			int cost = 0;
			int edge = 0;
			for(int i = 0;i<m;i++){
				fid = sc.nextInt();
				sid = sc.nextInt();
				cost = sc.nextInt();
				if(cost <= k){
					if(!flag[fid]){
						count ++;
					}
					if(!flag[sid]){
						count++;
					}
					if(!(flag[fid] && !flag[sid])){
						edge++;
					}
					flag[fid] = true;
					flag[sid] = true;
				}
			}
			if(count > n){
				System.out.println("Yes");
			}else if(count == n && edge >= n-1){
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
			T--;
		}
		sc.close();
	}
}
