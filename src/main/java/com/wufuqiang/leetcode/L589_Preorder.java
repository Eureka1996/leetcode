package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @ author wufuqiang
 **/
public class L589_Preorder {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.isEmpty()){
            Node nodeTmp = stack.pollLast();
            List<Node> children = nodeTmp.children;
            int childrenSize = children.size();
            for(int i = childrenSize-1;i>=0;i--){
                stack.add(children.get(i));
            }
            result.push(nodeTmp.val);

        }
        return result;
    }
}
