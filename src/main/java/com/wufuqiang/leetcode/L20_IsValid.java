package com.wufuqiang.leetcode;

import java.util.LinkedList;

/**
 * 有效的括号
 */
public class L20_IsValid {
	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<>();
		char tmp = 0;
		for(int i = 0;i<s.length();i++){
			tmp = s.charAt(i);
			if(tmp == '(' || tmp == '[' || tmp == '{'){
				stack.offerFirst(tmp);
			}else if(stack.size()>0 && isMatch(stack.peekFirst(),tmp)){
				stack.pollFirst();
			}else{
				return false;
			}
		}
		//还剩有左括号
		if(stack.size() > 0){
			return false;
		}
		return true;
	}
    //判断左右括号是否匹配
	public boolean isMatch(char left,char right){
		if((left == '(' && right==')') ||
			(left == '[' && right==']') ||
			(left == '{' && right=='}')){
			return true;
		}
		return false;
	}
}
