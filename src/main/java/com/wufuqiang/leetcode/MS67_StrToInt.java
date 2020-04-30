package com.wufuqiang.leetcode;
//字符串转数字
public class MS67_StrToInt {
	public int strToInt(String str) {
		if(str.length() == 0) return 0;
		int index = 0;
		while(str.charAt(index) == ' ') index++;
		boolean isMinux = false;
		if(str.charAt(index) == '-'){
			isMinux = true;
			index+=1;
		}else if(str.charAt(index) == '+'){
			isMinux = false;
			index+=1;
		}
		long value = 0;
		for(int i = index;i<str.length();i++){
			if(str.charAt(i)>='0' && str.charAt(i)<='9'){
				value=value*10+str.charAt(i)-'0';
				if(isMinux && value-1>Integer.MAX_VALUE){
					value = Integer.MAX_VALUE+1l;
					break;
				}else if(!isMinux && value > Integer.MAX_VALUE){
					value = Integer.MAX_VALUE;
					break;
				}
			}else{
				break;
			}
		}

		return (int)(isMinux?-value:value);
	}
}
