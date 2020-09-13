package com.wufuqiang.vivo.q20200912;

import java.util.Scanner;

public class Main2 {
	private static int pos = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean res = validPalindromeRec(str, 0, str.length() - 1, false);
		if(res){
			System.out.println(str.substring(0,pos)+str.substring(pos+1));
		}else{
			System.out.println("false");
		}

		sc.close();
	}

	public static boolean validPalindromeRec(String s ,int low , int high,boolean flag){
		if(low>=high){
			return true;
		}
		if(s.charAt(low) == s.charAt(high)){
			return validPalindromeRec(s,low+1,high-1,flag);
		}else{
			if(flag){
				return false;
			}else{
				boolean b1 = validPalindromeRec(s, low + 1, high, !flag);
				boolean b2 = validPalindromeRec(s, low, high - 1, !flag);
				int post = b1? low:high;
				pos = Math.min(post,pos);
				return b1 || b2 ;
			}

		}
	}
}
