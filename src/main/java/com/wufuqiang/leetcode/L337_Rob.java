package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L337_Rob {
    public int rob(TreeNode root) {
        return getMaxRob(root);
    }
    public int getMaxRob(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        int leftRob = getMaxRob(root.left);
        int rightRob = getMaxRob(root.right);
        int nextLevelSum = 0;
        if(root.left != null){
            nextLevelSum+=(getMaxRob(root.left.left)+getMaxRob(root.left.right));
        }
        if(root.right != null){
            nextLevelSum+=(getMaxRob(root.right.left)+getMaxRob(root.right.right));
        }
        return Math.max(leftRob+rightRob,root.val+nextLevelSum);
    }
}
