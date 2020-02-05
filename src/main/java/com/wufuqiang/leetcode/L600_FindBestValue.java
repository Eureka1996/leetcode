package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @ author wufuqiang
 **/
public class L600_FindBestValue {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0 ;i<arr.length;i++){
            int targetTmp = target-sum;
            int count = arr.length - i - 1;
            int quotient = targetTmp / count;
            if( (i > 0 || true) && quotient <= arr[i]){

            }
            int mod = targetTmp % count;
            if(mod * 2 > count){
                quotient+=1;
            }
        }
        return 0;
    }
}
