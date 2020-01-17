package com.wufuqiang.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ author wufuqiang
 **/
public class L155_MinStack {
}

class MinStack {

    Stack<Integer> data ;
    Stack<Integer> helper ;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<Integer>();
        helper = new Stack<Integer>();
    }

    public void push(int x) {
        data.add(x);
        if(helper.isEmpty() || helper.peek()>=x){
            helper.add(x);
        }
    }

    public void pop() {
        if(!data.isEmpty()){
            int top = data.pop();
            if(top == helper.peek()){
                helper.pop();
            }
        }

    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈为空");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈为空");
    }
}