package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.LinkedList;

/**
 * @ author wufuqiang
 **/
public class L993_IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int levelCount = 1;
        while(!queue.isEmpty()){
            int newLevelCount = 0;
            boolean flag = false;
            while(levelCount>0){
                TreeNode node = queue.pollFirst();
                levelCount --;
                if(node.val == x || node.val == y){
                    if(flag){
                        return true;
                    }else{
                        flag = true;
                    }
                }
                if(node.left != null && node.right != null){
                    if( (node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)){
                        return false;
                    }
                }
                if(node.left != null){
                    newLevelCount++;
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    newLevelCount++;
                    queue.addLast(node.right);
                }
            }
            levelCount = newLevelCount;
        }
        return false;
    }
}
