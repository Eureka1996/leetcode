package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 迭代，后序遍历
 */
public class L145_PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		//当前访问节点
		TreeNode cur = root;
		//上次访问节点
		TreeNode last = null;
		while(cur != null){
			stack.offerFirst(cur);
			cur = cur.left;
		}
		while(!stack.isEmpty()){
			TreeNode tmp = stack.pollFirst();
			if(tmp.right == null || tmp.right == last){
				result.add(tmp.val);
				last = tmp;
			}else{
				stack.offerFirst(tmp);
				cur = tmp.right;
				while(cur!=null){
					stack.offerFirst(cur);
					cur = cur.left;
				}
			}
		}

		return result;
	}
}
