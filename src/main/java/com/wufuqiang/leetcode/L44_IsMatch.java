package com.wufuqiang.leetcode;

public class L44_IsMatch {
	public boolean isMatch(String s, String p) {
		//p是否为空
		if(p.isEmpty()) return s.isEmpty();

		if(s.isEmpty()){
			if(p.isEmpty() || p.equals("*")) return true;
			else return false;
		}
		if(p.charAt(0) == '*'){
			return isMatch(s,p.substring(1)) || isMatch(s.substring(1),p);
		}else{
			//判断第一个字符是否相等
			boolean firstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '?';
			return firstMatch && isMatch(s.substring(1),p.substring(1));
		}
	}

	public static void main(String[] args) {
		L44_IsMatch l44 = new L44_IsMatch();
		String s = "aa";
		String p = "a";
		boolean match = l44.isMatch(s, p);
		System.out.println(match);
	}
}
