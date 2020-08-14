package com.wufuqiang.leetcode;

import java.util.LinkedList;
//接雨水
public class L42_Trap {
	public static void main(String[] args) {
		L42_Trap l42 = new L42_Trap();
		int result = l42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
		System.out.println(result);
	}
	public int trap(int[] height) {
		int result = 0;
		//栈存放的是柱子数组的索引
		LinkedList<Integer> stack = new LinkedList<>();
		for(int i = 0;i<height.length;i++){
			//1、若栈为空，肯定接不往水，直接不进入循环，直接将柱子入栈
			//2、遍历到的柱子，比栈顶的柱子高，则有可能接往雨水，则进入循环
			while(!stack.isEmpty() && height[i] > height[stack.peekFirst()]){
				//弹出栈顶柱子索引
				int cur = stack.pollFirst();
				//如果弹出一个后，栈为空，则肯定接不往雨水，可直接跳出循环
				if(stack.isEmpty()) break;
				//不弹出，获取栈顶的柱子索引，与现在的柱子组合可接雨水
				int l = stack.peekFirst();
				int r = i;
				//(r-l-1)为蓄水的长度
				//(Math.min(height[r],height[l])-height[cur])为蓄水的高度
				result += ((r-l-1) * (Math.min(height[r],height[l])-height[cur]));
			}
			stack.offerFirst(i);
		}

		return result;
	}
}
