package com.wufuqiang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MS01_01_IsUnique {
	public boolean isUnique(String astr) {
		boolean flag = true;
		Set<Character> set = new HashSet<>();
		for(int i = 0;i<astr.length();i++){
			char c= astr.charAt(i);
			if(set.contains(c)){
				flag = false;
				break;
			}else{
				set.add(c);
			}
		}
		return flag;
	}
}
