package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 层次遍历
 */
public class L102_LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		//存储最终结果
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;

		//存储每一层的节点
		LinkedList<TreeNode> queue = new LinkedList<>();
		//将第一层入队列，即根节点
		queue.offerLast(root);
		int size = 0;
		TreeNode tmpNode = null;
		while (!queue.isEmpty()){
			size = queue.size();
			List<Integer> everyLevel = new ArrayList<>();
			//处理每一层的节点
			while(size>0){
				size--;
				tmpNode = queue.pollFirst();
				everyLevel.add(tmpNode.val);
				if(tmpNode.left != null) queue.offerLast(tmpNode.left);
				if(tmpNode.right != null) queue.offerLast(tmpNode.right);
			}
			result.add(everyLevel);
		}
		return result;
	}
}
