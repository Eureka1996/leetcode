package com.wufuqiang.leetcode.mianshiti;

import java.util.Stack;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-31 14:18
 */
public class MS03_04_MyQueue {
    public static void main(String[] args) {

    }
}


class MyQueue {

    private Stack<Integer> stack1 ;
    private Stack<Integer> stack2 ;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}

