package com.wufuqiang.leetcode;

public class L896_IsMonotonic {
    public boolean isMonotonic(int[] A) {
        boolean result = true;
        if(A.length < 3){
            return result;
        }
        //是否是递增
        boolean isIncre = false;
        int i = 0;
        int pre = A[0];
        for(i = 1 ; i < A.length;i++){
            if(pre == A[i]) continue;
            if(pre<A[i]){
                isIncre = true;
                pre = A[i];
            }else{
                pre = A[i];
            }
            i++;
            break;
        }
        for(;i<A.length;i++){
            if(isIncre){
               if(pre > A[i]){
                   result = false;
                   return result;
               }
               pre = A[i];
            }else{
                if(pre < A[i]){
                    result = false;
                    return result;
                }
                pre = A[i];
            }
        }
        return result;
    }
}
