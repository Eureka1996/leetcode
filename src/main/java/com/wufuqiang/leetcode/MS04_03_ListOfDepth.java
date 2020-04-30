package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;
import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
//层次遍历
public class MS04_03_ListOfDepth {
	public ListNode[] listOfDepth(TreeNode tree) {
		if(tree == null) return new ListNode[0];
		ArrayList<ListNode> result = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerLast(tree);
		while(!queue.isEmpty()){
			int levelSize = queue.size();
			ListNode node = new ListNode(0);
			ListNode tmp = node;
			while(levelSize>0){
				levelSize-=1;
				TreeNode treeNode = queue.pollFirst();
				tmp.next = new ListNode(treeNode.val);
				tmp = tmp.next;
				if(treeNode.left!=null) queue.add(treeNode.left);
				if(treeNode.right!=null) queue.add(treeNode.right);
			}
			result.add(node.next);
		}

		return result.toArray(new ListNode[result.size()]);
	}
}
