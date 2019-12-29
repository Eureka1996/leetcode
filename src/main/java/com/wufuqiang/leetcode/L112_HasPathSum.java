package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @ author wufuqiang
 **/
public class L112_HasPathSum {

    private boolean sumRec(TreeNode root,int curSum,int sum){
        if(root.left == null && root.right == null){
            return (curSum+root.val) == sum;
        }
        boolean leftFlag = false;
        if(root.left != null){
            leftFlag = sumRec(root.left,curSum+root.val,sum);
        }
        boolean rightFlag = false;
        if(root.right != null){
            rightFlag =sumRec(root.right,curSum+root.val,sum);
        }
        return leftFlag || rightFlag;
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            if(sum == 0){
                return true;
            }else{
                return false;
            }
        }
        return sumRec(root,0,sum);
    }
}
