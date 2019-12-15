package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/15/015 - 13:08
 **/
public class L62_UniquePaths {
    public int uniquePaths(int m, int n) {
        int route[][] = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            route[i][0] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            route[0][i] = 1;
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                route[i][j] = route[i-1][j] + route[i][j-1];
            }
        }
        return route[m-1][n-1];
    }
}
