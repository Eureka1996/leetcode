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
        //如果节点为空，则肯定不包含给定的节点
        if(root == null) return false;
        //若左子树包含则为1，不包含则为0
        int left = recursion(root.left,p,q)?1:0;
        //若右子树包含则为1，不包含则为0
        int right = recursion(root.right,p,q)?1:0;
        //若当前节点是p或q，则为1，否则为0
        int mid = (root == p || root == q) ? 1:0;
        //
        if((left+right+mid) >= 2) ans = root;
        return (left+right+mid)>0;
    }
}
