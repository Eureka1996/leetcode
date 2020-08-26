package com.wufuqiang.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ author wufuqiang
 **/
public class L155_MinStack {
}

class MinStack {

    //实际的栈操作
    Stack<Integer> data ;
    //记录最小值的栈操作
    Stack<Integer> helper ;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<Integer>();
        //此栈记录当前的最小值
        helper = new Stack<Integer>();
    }

    //入栈
    public void push(int x) {
        data.push(x);
        //新进来的值和栈顶做比较，如果小于等于栈顶，则入栈，更新最小值
        if(helper.isEmpty() || helper.peek()>=x){
            helper.push(x);
        }
    }

    //出栈
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