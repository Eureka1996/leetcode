package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/15/015 - 16:16
 **/
public class L63_UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] route = new int[m][n];
        boolean flag = false;
        for(int i = 0 ; i < m ; i++){
            if(obstacleGrid[i][0] == 1 || flag){
                route[i][0] = 0;
                flag = true;
            }else{
                route[i][0] = 1;
            }
        }
        flag = false;
        for(int i = 0 ; i < n ; i++){
            if(obstacleGrid[0][i] == 1 || flag){
                route[0][i] = 0;
                flag = true;
            }else{
                route[0][i] = 1;
            }
        }
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n ; j++){
                if(obstacleGrid[i][j] == 1){
                    route[i][j] = 0;
                }else{
                    route[i][j] = route[i-1][j] + route[i][j-1];
                }
            }
        }

        return route[m-1][n-1];
    }
}
