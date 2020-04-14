package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//层次遍历
// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
//  [20,9],
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
// Related Topics 树 广度优先搜索
public class MS32_3_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int levelCount = 1;
        //记录遍历的方向，true为向右，false为向左
        boolean direction = true;
        while(!queue.isEmpty()){
            int nextLevelCount = 0;
            List<Integer> levelList = new ArrayList<>();
            while(levelCount>0){
                TreeNode node = null;
                if(direction){
                    node = queue.pollFirst();
                }else{
                    node = queue.pollLast();
                }

                levelList.add(node.val);
                if(direction){
                    if(node.left!= null){
                        nextLevelCount+=1;
                        if(direction){
                            queue.offerLast(node.left);
                        }else{
                            queue.offerFirst(node.left);
                        }

                    }
                    if(node.right!= null){
                        nextLevelCount+=1;
                        if(direction){
                            queue.offerLast(node.right);
                        }else{
                            queue.offerFirst(node.right);
                        }
                    }
                }else{

                    if(node.right!= null){
                        nextLevelCount+=1;
                        if(direction){
                            queue.offerLast(node.right);
                        }else{
                            queue.offerFirst(node.right);
                        }
                    }
                    if(node.left!= null){
                        nextLevelCount+=1;
                        if(direction){
                            queue.offerLast(node.left);
                        }else{
                            queue.offerFirst(node.left);
                        }

                    }
                }

                levelCount-=1;
            }
            direction = !direction;
            result.add(levelList);
            levelCount = nextLevelCount;
        }
        return result;
    }
}
