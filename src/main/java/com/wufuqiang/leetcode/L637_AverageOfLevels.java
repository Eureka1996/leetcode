package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ author wufuqiang
 **/
public class L637_AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int levelCount = 1;
        while(!queue.isEmpty()){
            long levelSum = 0;
            int newLevelCount = 0;
            int tmpCount = levelCount;
            while(levelCount > 0){
                TreeNode node = queue.pollFirst();
                levelCount--;
                levelSum+=node.val;
                if(node.left != null){
                    newLevelCount+=1;
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    newLevelCount +=1;
                    queue.addLast(node.right);
                }
            }
            levelCount = newLevelCount;
            result.add(levelSum*1.0/tmpCount);
        }
        return result;
    }
}
