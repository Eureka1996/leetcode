package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//窗口函数
public class L3_LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		if(s == null || s.length() == 0) return res;
		Set<Character> window = new HashSet<>();
		boolean flag = true;
		int left = 0;
		int right = 0;
		while(right < s.length()){
			if(!window.contains(s.charAt(right))){
				window.add(s.charAt(right));
				res = Math.max(res,window.size());
				right+=1;
			}else{
				window.remove(s.charAt(left));
				left+=1;
			}
		}

		return res;
	}
}
