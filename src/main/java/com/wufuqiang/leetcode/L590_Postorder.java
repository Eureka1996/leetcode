package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 10:49
 **/
public class L590_Postorder {

    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        if(root == null){
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for(Node child : node.children){
                if(child != null){
                    stack.add(child);
                }
            }
        }
        return output;
    }
}
