package com.wufuqiang.leetcode;

/**
 * 三维，背包问题
 * @author: Wu Fuqiang
 * @create: 2021-06-06 00:34
 */
public class L474_FindMaxForm {
    public static void main(String[] args) {

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        int zeros = 0;
        int ones = 0;

        for(int i = 0;i<strs.length;i++){
            zeros = 0;ones=0;
            for(char c : strs[i].toCharArray()){
                if(c == '0') zeros+=1;
                else ones+=1;
            }
            for(int j = 0;j<=m;j++){
                for(int k = 0;k<=n;k++){
                    dp[i+1][j][k] = dp[i][j][k];
                    if(j>=zeros && k>=ones){
                        dp[i+1][j][k] = Math.max(dp[i+1][j][k],dp[i][j-zeros][k-ones]+1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
