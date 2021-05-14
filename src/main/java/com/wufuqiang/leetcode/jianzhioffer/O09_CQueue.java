package com.wufuqiang.leetcode.jianzhioffer;

import java.util.Stack;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-14 18:46
 */
public class O09_CQueue {
    public static void main(String[] args) {

    }
}


class CQueue {

    //用于加入
    Stack<Integer> stack1 = null;
    //用于删除
    Stack<Integer> stack2 = null;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack2.size() == 0 && stack1.size() == 0){
            return -1;
        }
        if(stack2.size() == 0){
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
