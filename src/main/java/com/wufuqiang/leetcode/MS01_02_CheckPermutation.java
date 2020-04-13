package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MS01_02_CheckPermutation {
	public static void main(String[] args) {
		System.out.println(checkPermutation("abc","bac"));
	}

	public static boolean checkPermutation(String s1, String s2) {
		boolean flag = true;
		if(s1.length() != s2.length()){
			flag = false;
		}else{
			Map<Character,Integer> needs = new HashMap<>();
			Map<Character,Integer> window = new HashMap<>();

			for(int i = 0;i<s1.length();i++){
				char c = s1.charAt(i);
				Integer n = needs.getOrDefault(c, 0);
				n+=1;
				needs.put(c,n);
			}
			int match = 0;

			for(int i = 0;i<s2.length();i++){
				char c = s2.charAt(i);
				if(needs.containsKey(c)){
					Integer n = window.getOrDefault(c, 0);
					n+=1;
					window.put(c,n);
					if(needs.get(c).equals(n)){
						match+=1;
					}else if(needs.get(c) < n){
						flag = false;
						break;
					}
				}else{
					flag = false;
					break;
				}
			}
			if(match != needs.size()){
				flag = false;
			}
		}

		return flag;
	}
}
