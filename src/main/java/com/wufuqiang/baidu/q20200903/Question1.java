package com.wufuqiang.baidu.q20200903;

import java.util.Scanner;

public class Question1 {
	private static int countZero = 0;
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int n = scaner.nextInt();
		int[] nums = new int[n];
		for(int i = 0 ;i<n;i++){
			nums[i] = scaner.nextInt();
			if(nums[i] == 0){
				countZero++;
			}
		}

		if(countZero == 0) {
			System.out.println(-1);
		}else if(countZero == n){
			System.out.println(-1);
		}else{
			int countFive = n-countZero;

			int c = (countFive/9)*9;
			if(c==0){
				System.out.println(-1);
			}else{
				StringBuilder sb = new StringBuilder();
				for(int i = 0;i<c;i++){
					sb.append(5);
				}
				for(int i = 0;i<countZero;i++){
					sb.append(0);
				}
				System.out.println(sb.toString());
			}
		}

		scaner.close();
	}
}
