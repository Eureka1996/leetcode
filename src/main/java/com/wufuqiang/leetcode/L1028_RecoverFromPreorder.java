package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.LinkedList;
//前序遍历还原
public class L1028_RecoverFromPreorder {
	public TreeNode recoverFromPreorder(String S) {
		if(S.length()==0)return null;


		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> levelStack = new LinkedList<>();

		TreeNode lastNode = new TreeNode(0);
		TreeNode result = lastNode;
		int level = 0;
		int value = 0;
		boolean flag = true;
		for(int i = 0;i<S.length();i++){
			if(S.charAt(i) == '-'){
				if(flag){
					TreeNode node = new TreeNode(value);
					if(lastNode.left == null) lastNode.left = node;
					else lastNode.right = node;
					stack.offerFirst(node);
					levelStack.offerFirst(level);
					lastNode = node;
					level=0;
				}
				flag = false;
				level+=1;
			}else{
				if(!flag) value = 0;
				while(!stack.isEmpty() && levelStack.peekFirst() >= level){
					stack.pollFirst();
					levelStack.pollFirst();
					lastNode = stack.peekFirst();
				}
				flag = true;
				value=value*10+S.charAt(i)-'0';
			}
		}

		TreeNode n = new TreeNode(value);
		if(lastNode.left == null) lastNode.left = n;
		else lastNode.right = n;

		return result.left;
	}
}
