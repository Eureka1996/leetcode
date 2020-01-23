package com.wufuqiang.leetcode;

import java.util.Stack;

/**
 * @ author wufuqiang
 **/
public class L735_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ;i < asteroids.length;i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
            }else{
                while(true){
                    if(stack.isEmpty()){
                        stack.push(asteroids[i]);
                        break;
                    }
                    Integer peek = stack.peek();
                    if(peek>0 && asteroids[i]<0){
                        int right = -asteroids[i];
                        if(peek > right){
                            break;
                        }else if(peek < right){
                            stack.pop();
                        }else{
                            stack.pop();
                            break;
                        }
                    }else{
                        stack.push(asteroids[i]);
                        break;
                    }
                }

            }
        }
        int[] result = new int[stack.size()];
        int size = stack.size();
        for(int i = size-1 ; i >= 0 ;i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
