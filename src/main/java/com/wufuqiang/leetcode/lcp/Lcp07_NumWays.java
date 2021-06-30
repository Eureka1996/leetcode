package com.wufuqiang.leetcode.lcp;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-01 00:35
 */
public class Lcp07_NumWays {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1;
        for(int i = 0;i<k;i++){
            for(int[] rel : relation){
                dp[i+1][rel[1]] += dp[i][rel[0]];
            }
        }
        return dp[k][n-1];
    }
}
