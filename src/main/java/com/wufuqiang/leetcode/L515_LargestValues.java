package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//二叉树，每层最大值
public class L515_LargestValues {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerLast(root);

		while(!queue.isEmpty()){
			int levelSize = queue.size();
			int max = Integer.MIN_VALUE;
			while(levelSize>0){
				TreeNode tmp = queue.pollFirst();
				if(max<tmp.val) max = tmp.val;
				if(tmp.left != null) queue.offerLast(tmp.left);
				if(tmp.right != null) queue.offerLast(tmp.right);
				levelSize-=1;
			}
			res.add(max);
		}



		return res;
	}


}
