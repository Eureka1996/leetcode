package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-21 00:21
 */
public class L1035_MaxUncrossedLines {
    public static void main(String[] args) {

    }
    public int maxUncrossedLines(int[] A, int[] B) {

        int[][] dp = new int[A.length+1][B.length+1];
        for(int i = 0;i<=A.length;i++) dp[i][0] = 0;
        for(int i = 0;i<=B.length;i++) dp[0][i] = 0;
        for(int i = 1;i<=A.length;i++){
            for(int j = 1;j<=B.length;j++){
                if(A[i-1] == B[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[A.length][B.length];
    }
}
