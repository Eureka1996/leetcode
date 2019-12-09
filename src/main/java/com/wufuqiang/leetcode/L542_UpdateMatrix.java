package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/9/009 - 18:35
 **/
public class L542_UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return matrix;
        }
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0; j < cols ; j++){
                dist[i][j] = Integer.MAX_VALUE-100;
            }
        }

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(matrix[i][j] == 0){
                    dist[i][j] = 0;
                }else{
                    if(i>0){
                        dist[i][j] = Math.min(dist[i][j],dist[i-1][j]+1);
                    }
                    if(j>0){
                        dist[i][j] = Math.min(dist[i][j],dist[i][j-1]+1);
                    }
                }
            }
        }

        for(int i = rows-1;i>=0;i--){
            for(int j = cols-1;j>=0 ;j--){
                if(i<rows-1){
                    dist[i][j] = Math.min(dist[i][j],dist[i+1][j]+1);
                }
                if(j<cols-1){
                    dist[i][j] = Math.min(dist[i][j],dist[i][j+1]+1);
                }
            }
        }

        return dist;
    }
}
