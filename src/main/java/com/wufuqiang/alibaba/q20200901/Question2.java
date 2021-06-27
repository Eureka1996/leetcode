package com.wufuqiang.alibaba.q20200901;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2 {

	private static int[] rc = null;
	private static String[] strs = null;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		int m = scanner.nextInt();
//		String s = scanner.nextLine();
		int n =3; //Integer.parseInt(s.split(" ")[0]);
		int m =5;// Integer.parseInt(s.split(" ")[1]);
		String[] str = new String[]{"01101","10100","00011"};
		int[] rightCount = new int[]{4,2,3};
		String tmp = "";
		boolean[][] roe = new boolean[n][m];
//		for(int i = 0;i<n;i++){
//			tmp = scanner.nextLine();
//			str[i] = tmp.split(" ")[0];
//			rightCount[i] =Integer.parseInt( tmp.split(" ")[1]);
//		}
		rc = rightCount;
		strs = str;

		List<String> result = new ArrayList<>();
		backtrack(0,n,m,result,new StringBuilder());

		if(result.size()==1){
			System.out.println(result.get(0));
		}else{
			System.out.println(result.size());
		}
		scanner.close();
	}

	public static void backtrack(int index,int n, int m, List<String> result,StringBuilder sb){

		if(index == m){
			for(int i=0;i<n;i++){
				if(rc[i] != 0){
					return;
				}
			}
			result.add(sb.toString());
			return;
		}

		char tmp = strs[0].charAt(index);
		if(rc[0]>0){
			rc[0]=rc[0]-1;
			sb.append(tmp);
			int i = 1;
			for(;i<n;i++){
				if(strs[i].charAt(index) == tmp){
					rc[i]-=1;
					if(rc[i]<0){
						break;
					}
				}
			}
			if(i==n){
				backtrack(index+1,n,m,result,sb);
			}
			for(i=n-1;i>=1;i--){
				if(strs[i].charAt(index) == tmp) rc[i]+=1;
			}


			sb.deleteCharAt(sb.length()-1);
			rc[0]=rc[0]+1;
		}

		tmp = tmp == '1'?'0':'1';
		sb.append(tmp);
		int i = 1;
		for(;i<n;i++){
			if(strs[i].charAt(index) == tmp){
				rc[i]-=1;
				if(rc[i]<0){
					break;
				}
			}
		}
		if(i==n){
			backtrack(index+1,n,m,result,sb);
		}
		for(i=n-1;i>=1;i--){
			if(strs[i].charAt(index) == tmp) rc[i]+=1;
		}

		sb.deleteCharAt(sb.length()-1);
	}
}
