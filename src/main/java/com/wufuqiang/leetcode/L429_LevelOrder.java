package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ author wufuqiang
 **/
public class L429_LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Node> stack = new LinkedList<>();
        if(root == null) return result;
        stack.add(root);
        int levelSize = 1;
        while(!stack.isEmpty()){
            int levelSizeTmp = 0;
            List<Integer> levelResult = new ArrayList<>();
            while(levelSize > 0){
                Node node = stack.pollFirst();
                for(Node n : node.children){
                    levelSizeTmp+=1;
                    stack.add(n);
                }
                levelSize-=1;
                levelResult.add(node.val);
            }

            result.add(levelResult);
            levelSize = levelSizeTmp;
        }
        return result;
    }
}
