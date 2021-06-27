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

	public List<Integer> postorderTraversal2(TreeNode root){
		List<Integer> result = new ArrayList<>();
        postorder(root,result);
		return result;
	}

	public void postorder(TreeNode root,List<Integer> result){
		if(root == null) return;
		postorder(root.left,result);
		postorder(root.right,result);
		result.add(root.val);
	}

	public List<Integer> postorderTraversal3(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		LinkedList<TreeNode> stack = new LinkedList<>();
		//当前访问节点
		TreeNode cur = root;
		//上次访问节点
		TreeNode prev = null;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.offerFirst(cur);
				cur = cur.left;
			}
			TreeNode tmp = stack.pollFirst();
			if(tmp.right == null || tmp.right == prev){
				result.add(tmp.val);
				prev = tmp;
			}else{
				stack.offerFirst(tmp);
				cur = tmp.right;
			}
		}

		return result;
	}
}
