package com.wufuqiang.leetcode;

import java.util.Arrays;

public class L869_ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        int[] A = count(N);
        for(int i = 0 ; i<31;i++){
            if(Arrays.equals(A,count(1<<i))){
                return true;
            }
        }
        return false;
    }

    public int[] count(int N){
        int[] count = new int[10];
        while(N>0){
            int mod = N%10;
            count[mod] = count[mod]+1;
            N /= 10;
        }
        return count;
    }
}
