package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-14 09:14
 */
public class L374_GuessNumber {
    public static void main(String[] args) {

    }
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessNumber(1,n);
    }

    public int guessNumber(int low ,int high){
        int mid = low + (high-low)/2;
        int guess = guess(mid);
        if(guess == 0){
            return mid;
        }else if(guess==-1){
            return guessNumber(low,mid-1);
        }else{
            return guessNumber(mid+1,high);
        }
    }
}
