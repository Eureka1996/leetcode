package com.wufuqiang.leetcode;

public class L766_IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean flag = true;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0 ; j < matrix[0].length;j++){
                if(i>0 && j>0 && matrix[i][j] != matrix[i-1][j-1]){
                    return flag;
                }
            }
        }
        return flag;
    }
}
