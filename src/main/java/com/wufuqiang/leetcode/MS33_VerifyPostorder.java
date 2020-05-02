package com.wufuqiang.leetcode;

import java.util.Stack;

//验证后序遍历 单调栈
public class MS33_VerifyPostorder {

	public boolean verifyPostorder(int[] postorder) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MAX_VALUE;
		for(int i = postorder.length - 1; i >= 0; i--) {
			if(postorder[i] > root) return false;
			while(!stack.isEmpty() && stack.peek() > postorder[i])
				root = stack.pop();
			stack.add(postorder[i]);
		}
		return true;
	}
}
