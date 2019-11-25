package com.wufuqiang.leetcode;

import java.util.Random;

public class L384_Shuffle {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    public L384_Shuffle(int[] nums){
        array = nums;
        original = nums.clone();
    }

    private int randRange(int min , int max){
        return rand.nextInt(max-min) + min;
    }

    private void swapAt(int i ,int j){
        int tmp = array[i];
        array[i]= array[j];
        array[j] = tmp;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < array.length;i++){
            swapAt(i,randRange(i,array.length));
        }
        return array;
    }

}
