package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @author Wu Fuqiang
 * @date 2021/11/9 1:58 下午
 */
public class L617_MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left,root2.left);
        merged.right = mergeTrees(root1.right,root2.right);
        return merged;
    }
}
