package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 10:01
 **/
public class L235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode rootTmp = root;
        boolean flag = true;
        while(flag){
            if(rootTmp.val > p.val && rootTmp.val > q.val){
                rootTmp = rootTmp.left;
            }else if(rootTmp.val < p.val && rootTmp.val < q.val){
                rootTmp = rootTmp.right;
            }else{
                flag = false;
            }
        }
        return rootTmp;
    }
}
