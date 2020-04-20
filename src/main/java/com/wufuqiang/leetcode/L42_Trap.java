package com.wufuqiang.leetcode;

import java.util.LinkedList;
//接雨水
public class L42_Trap {
	public static void main(String[] args) {
		L42_Trap l42 = new L42_Trap();
		int result = l42.trap(new int[]{4,2,3});
		System.out.println(result);
	}
	public int trap(int[] height) {
		int result = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		for(int i = 0;i<height.length;i++){
			while(!stack.isEmpty() && height[i] > height[stack.peekFirst()]){
				int cur = stack.pollFirst();
				if(stack.isEmpty()) break;
				int l = stack.peekFirst();
				int r = i;
				result += ((r-l-1) * Math.min(height[r],height[l])-height[cur]);
			}
			stack.offerFirst(i);
		}

		return result;
	}
}
