package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L1026_MaxAncestorDiff {
    private int result = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,root.val,root.val);
        return result;
    }

    public void dfs(TreeNode root,int max , int min){
        if(root == null){
            return;
        }
        max = Math.max(root.val, max);
        min = Math.min(root.val,min);
        if(root.left == null && root.right == null){
            this.result = Math.max(result,Math.abs(max-min));
        }
        dfs(root.left,max,min);
        dfs(root.right,max,min);
    }
}
