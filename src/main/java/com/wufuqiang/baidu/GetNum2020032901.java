package com.wufuqiang.baidu;

import java.util.Arrays;
import java.util.Scanner;

public class GetNum2020032901 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] nNum = new int[n];
		int[] mNum = new int[n];
		for(int i = 0 ;i < n ;i++){
			nNum[i] = scanner.nextInt();
		}
		for(int i = 0 ;i<n ;i++){
			mNum[i] = scanner.nextInt();
		}
		if(m>1){
			for(int i = 1 ; i < m;i++){
				mNum[i] = mNum[i] + mNum[i-1];
			}
		}
		Arrays.sort(nNum);
		for(int i:nNum){
			System.out.println(i);
		}
		int count = 0;
		for(int i = n-1 ;i>=n-m;i--){
			count+=nNum[i];
		}
		for(int i = 0 ; i < m-1;i++){
			count -= mNum[i];
		}
		System.out.println(count);

	}
}
