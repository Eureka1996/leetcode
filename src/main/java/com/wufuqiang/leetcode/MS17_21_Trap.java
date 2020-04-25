package com.wufuqiang.leetcode;

import java.util.LinkedList;

//接雨水
public class MS17_21_Trap {
	public int trap(int[] height) {
		int result = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		for(int i = 0;i<height.length;i++){
			if(!stack.isEmpty() && height[i]>height[stack.peekFirst()]){
				int mid = stack.pollFirst();
				if(stack.isEmpty()) break;
				int left = stack.peekFirst();
				result += ((i-left-1)*(Math.min(height[left],height[i])-height[mid]));
			}
			stack.offerFirst(i);
		}
		return result;
	}
}
