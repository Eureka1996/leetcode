package com.wufuqiang.leetcode;

public class L1299_ReplaceElements {
    public int[] replaceElements(int[] arr) {
        if(arr == null || arr.length == 0){
            return new int[0];
        }
        int maxRight = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for(int i = arr.length-2;i>=0;i--){
            int tmp = arr[i];
            arr[i] = maxRight;
            if(tmp > maxRight){
                maxRight = tmp;
            }
        }
        return arr;
    }
}
