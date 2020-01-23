package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @ author wufuqiang
 **/
public class L1302_DeepestLeavesSum {
    private int maxDep = -1;
    private int levelSum = 0;

    public void dfs(TreeNode root,int dep){
        if(root == null){
            return;
        }
        if(dep > maxDep){
            maxDep = dep;
            levelSum = root.val;
        }else if(dep == maxDep){
            levelSum += root.val;
        }
        dfs(root.left,dep+1);
        dfs(root.right,dep+1);
    }

    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return levelSum;
    }
}
