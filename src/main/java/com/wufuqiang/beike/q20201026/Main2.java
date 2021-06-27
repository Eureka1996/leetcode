package com.wufuqiang.beike.q20201026;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0;i<T;i++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			for(int j = 0;j<n;j++){
				arr[j] = sc.nextInt();
			}
			System.out.println(solution(arr,n,m));
		}

		sc.close();
	}


	public static String solution(int[] arr,int n ,int m){
		Arrays.sort(arr);

		boolean flag = false;
		String res = "no";
		int low = 0;
		int high = arr.length-1;
		while(low < high){
			int t = arr[low] * arr[high];
			if(t == m){
				res = "yes";
				flag = true;
				break;
			}else if(t > m){
				high--;
			}else{
				low++;
			}
		}
		if(!flag){
			res = "no";
		}
		return res;

	}
}
