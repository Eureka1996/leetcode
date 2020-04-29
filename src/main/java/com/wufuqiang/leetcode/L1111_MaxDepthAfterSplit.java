package com.wufuqiang.leetcode;
//有效括号的嵌套深度
public class L1111_MaxDepthAfterSplit {
	public int[] maxDepthAfterSplit(String seq) {
		int[] result = new int[seq.length()];
		int index = 0;
		for(char c : seq.toCharArray()){
			result[index] = c == '('?index&1:(index+1)&1;
			index+=1;
		}
		return result;
	}
}
