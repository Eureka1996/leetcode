package com.wufuqiang.haoweilai.q20200920;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		sc.close();
	}
	public int lenSubstring (String Str, int len) {
		// write code here
		int res = 0;
		if( Str == null || Str.length() == 0) return  res;
		Set<Character> window = new HashSet<>();
		int left = 0;
		int right = 0;
		while(right < Str.length()){
			if(!window.contains(Str.charAt(right))){
				window.add(Str.charAt(right));
				res = Math.max(res,window.size());
				right+=1;
			}else{
				window.remove(Str.charAt(left));
				left+=1;
			}
		}
		return res;
	}
}
