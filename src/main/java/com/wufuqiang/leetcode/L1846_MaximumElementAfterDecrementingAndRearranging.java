package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-15 00:11
 */
public class L1846_MaximumElementAfterDecrementingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i =1;i<arr.length;i++){
            if(arr[i]-arr[i-1] > 0){
                arr[i] = arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }
}
