package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 无重复字符的最长子串
 * 窗口函数+双指针
 */
public class L3_LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int res = 0;
		if(s == null || s.length() == 0) return res;
		Set<Character> window = new HashSet<>();
		int left = 0;
		int right = 0;
		while(right < s.length()){
			if(!window.contains(s.charAt(right))){
				//窗口中不包含这个字符，则加入到窗口，然后右指针右移
				window.add(s.charAt(right));
				res = Math.max(res,window.size());
				right+=1;
			}else{
				//窗口中包含了这个字符
				window.remove(s.charAt(left));
				left+=1;
			}
		}

		return res;
	}
}
