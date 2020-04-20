package com.wufuqiang.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class L1108_DefangIPaddr {
	public static void main(String[] args) {
		String str = defangIPaddr("192.168.1.23");
		System.out.println(str);
	}
	public static String defangIPaddr(String address) {
		char[] result = new char[address.length()+3*2];
		int index = 0;
		for(int i = 0;i<address.length();i++){
			char c = address.charAt(i);
			if(c == '.'){
				result[index] = '[';
				result[index+1] = '.';
				result[index+2] = ']';
				index+=3;

			}else{
				result[index] = c;
				index+=1;
			}
		}
		StringBuffer sb = new StringBuffer();
		for(char c : result){
			sb.append(c);
		}
		return sb.toString();
	}
}
