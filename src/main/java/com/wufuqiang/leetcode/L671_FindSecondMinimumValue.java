package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
import lombok.val;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-27 20:07
 */
public class L671_FindSecondMinimumValue {
    private int ans ;
    private int rootValue ;
    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootValue = root.val;
        secondMinValue(root);
        return ans;
    }

    public void secondMinValue(TreeNode root){
        if(root == null){
            return ;
        }
        if(ans != -1 && root.val >= ans){
            return;
        }
        if(root.val > rootValue){
            ans = root.val;
        }
        secondMinValue(root.left);
        secondMinValue(root.right);

    }
}
