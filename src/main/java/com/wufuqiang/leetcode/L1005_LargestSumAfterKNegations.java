package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L1005_LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        if(A==null || A.length == 0){
            return 0;
        }
        int minPositive = Integer.MAX_VALUE;
        List<Integer> minusList = new ArrayList<>();
        int sum = 0;
        for(int a : A){
            if(a<0){
                minusList.add(a);
            }else{
                if(minPositive>a){
                    minPositive=a;
                }
                sum+=a;
            }
        }
        if(minusList.size()>K){
            Collections.sort(minusList);
            int kTmp = 0;
            for(int minus : minusList){
                kTmp++;
                if(kTmp<=K){
                    sum+=(-minus);
                }else{
                    sum+=minus;
                }
            }
        }else{
            for(int minus : minusList){
                if(minPositive>(-minus)){
                    minPositive = -minus;
                }
                sum+=(-minus);
            }
            if((K-minusList.size())%2 == 1){
                sum -= (2*minPositive);
            }
        }
        return sum;
    }
}
