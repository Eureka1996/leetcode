package com.wufuqiang.leetcode;

import java.util.LinkedList;
//逆波兰数 四则运算 算数运算
public class L150_EvalRPN {
	public int evalRPN(String[] tokens) {
		LinkedList<Integer> stack = new LinkedList<>();
		for(String token : tokens){
			if(token.equals("+") ||
					token.equals("-") ||
					token.equals("*") ||
					token.equals("/")){
				int n2 = stack.pollFirst();
				int n1 = stack.pollFirst();
				stack.offerFirst(calc(n1,n2,token));
			}else{
				stack.offerFirst(Integer.parseInt(token));
			}
		}
		return stack.pollFirst();
	}

	public int calc(int n1,int n2,String ops){
		switch (ops){
			case "-":
				return n1 -n2;
			case "+":
				return n1+n2;
			case "*":
				return n1*n2;
			case "/":
				return n1/n2;
		}
		return 0;
	}
}
