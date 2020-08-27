package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L111_MinDepth {



    public int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if(root.left != null){
            minDepth = Math.min(minDepth(root.left),minDepth);
        }
        if(root.right != null){
            minDepth = Math.min(minDepth(root.right),minDepth);
        }
        return minDepth+1;

    }

    public int minDepth(TreeNode root) {
        //如果是空节点，高度为0
        if(root == null) return 0;

        //如果是叶子节点，高度为1
        if(root.left == null && root.right == null) return 1;

        int leftDepth = Integer.MAX_VALUE;
        if(root.left != null) leftDepth = minDepth(root.left);
        int rightDepth = Integer.MAX_VALUE;
        if(root.right != null) rightDepth = minDepth(root.right);
        return Math.min(leftDepth,rightDepth)+1;
    }
}
