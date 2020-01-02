package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.second.Node;

import java.util.LinkedList;

public class L116_Connect {

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        LinkedList<Node> query = new LinkedList<Node>();
        query.add(root);
        int levelCount = 1;
        while(!query.isEmpty()){
            int levelCountTmp = 0;
            Node poll = query.poll();
            if(poll.left != null) {
                query.add(poll.left);
                levelCountTmp+=1;
            }
            if(poll.right != null){
                query.add(poll.right);
                levelCountTmp+=1;
            }
            levelCount-=1;
            while(levelCount > 0){
                Node pollSecond = query.poll();
                levelCount-=1;
                poll.next = pollSecond;
                if(pollSecond.left != null){
                    query.add(pollSecond.left);
                    levelCountTmp+=1;
                }
                if(pollSecond.right != null){
                    query.add(pollSecond.right);
                    levelCountTmp+=1;
                }
                poll = pollSecond;
            }
            poll.next = null;
            levelCount = levelCountTmp;
        }

        return root;
    }
}
