package com.wufuqiang.leetcode.jianzhioffer;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-14 20:04
 */
public class O68_1_LowestCommonAncestor {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode leftNode = p.val < q.val ? p:q;
        TreeNode rightNode = p.val > q.val ? p:q;

        while(root != null){
            if(root.val > leftNode.val && root.val < rightNode.val){
                break;
            }else if(root.val < leftNode.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }

        return root;
    }
}
