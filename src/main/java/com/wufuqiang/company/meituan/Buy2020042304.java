package com.wufuqiang.company.meituan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Buy2020042304 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] category = new int[n][2];
		int acnt = 0;
		for(int i = 0;i<n;i++){
			category[i][0] = scanner.nextInt();
			category[i][1] = scanner.nextInt();
			if(category[i][1]==1) acnt+=1;
		}

		Arrays.sort(category, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) return -1;
				if(o1[0]<o2[0]) return 1;
				else return 0;
			}
		});
		double result = 0;
		int amin = 0;
		int kt = k;
		for(int[] c : category){
			if(c[1] == 1){
				if(k>1){
					result+= (c[0]*1.0/2);
					k-=1;
				}else{
					result+= c[0];
				}

				amin=c[0];

			}else{
				result+=c[0];
			}
		}
		if(acnt>=kt){
			result=result-category[n-1][0]/2;
		}
		System.out.println(String.format("%.2f",result));
	}

}
