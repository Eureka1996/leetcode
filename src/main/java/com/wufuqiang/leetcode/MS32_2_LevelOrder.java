package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//层次遍历
// 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
//
//
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/
// Related Topics 树 广度优先搜索

public class MS32_2_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int levelCount = 1;
        while(!queue.isEmpty()){
            int nextLevelCount = 0;
            List<Integer> levelList = new ArrayList<>();
            while(levelCount>0){
                TreeNode node = queue.pollFirst();
                levelList.add(node.val);
                if(node.left!= null){
                    nextLevelCount+=1;
                    queue.offerLast(node.left);
                }
                if(node.right!= null){
                    nextLevelCount+=1;
                    queue.offerLast(node.right);
                }
                levelCount-=1;
            }
            result.add(levelList);
            levelCount = nextLevelCount;
        }
        return result;
    }
}
