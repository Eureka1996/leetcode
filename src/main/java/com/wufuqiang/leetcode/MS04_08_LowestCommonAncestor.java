package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

// 共同祖先
public class MS04_08_LowestCommonAncestor {
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root,p,q);
        return ans;
    }

    public boolean recursion(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return false;
        int left = recursion(root.left,p,q)?1:0;
        int right = recursion(root.right,p,q)?1:0;
        int mid = (root == p || root == q) ? 1:0;
        if((left+right+mid) >= 2) ans = root;
        return (left+right+mid)>0;
    }
}
