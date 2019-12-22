package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 10:12
 **/
public class L236_LowestCommonAncestor {

    private TreeNode ans = null;

    private boolean recurseTree(TreeNode curNode, TreeNode p, TreeNode q){
        if (curNode == null) {
            return false;
        }
        int left = recurseTree(curNode.left,p,q)?1:0;
        int right = recurseTree(curNode.right,p,q)?1:0;
        int mid = (curNode.val == p.val || curNode.val == q.val)?1:0;
        if(left+right+mid>=2){
            this.ans = curNode;
        }
        return (left+right+mid)>0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        recurseTree(root,p,q);
        return this.ans;
    }
}
