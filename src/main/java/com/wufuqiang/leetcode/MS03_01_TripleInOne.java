package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-15 00:18
 */
public class MS03_01_TripleInOne {
    public static void main(String[] args) {

    }
}

class TripleInOne {
    int[][] arr = null;
    int[] index = null;
    int stackSize;

    public TripleInOne(int stackSize) {
        arr = new int[3][stackSize];
        index = new int[3];
        this.stackSize = stackSize;
        Arrays.fill(index,-1);
    }

    public void push(int stackNum, int value) {
        if(index[stackNum] < this.stackSize-1){
            arr[stackNum][++index[stackNum]] = value;
        }
    }

    public int pop(int stackNum) {
        if(index[stackNum] == -1) return -1;
        int tmp = arr[stackNum][index[stackNum]];
        index[stackNum]--;
        return tmp;
    }

    public int peek(int stackNum) {
        if(index[stackNum] == -1) return -1;
        return arr[stackNum][index[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        if(index[stackNum] == -1) return true;
        return false;
    }
}
