package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-13 09:06
 */
public class L1269_NumWays {
    public static void main(String[] args) {
        L1269_NumWays l = new L1269_NumWays();
        int i = l.numWays(4, 2);
        System.out.println(i);
    }
    public int numWays(int steps, int arrLen) {

        int maxColumn = Math.min(steps,arrLen-1);
        int[][] dp = new int[steps+1][maxColumn+1];
        dp[0][0] = 1;
        for(int i = 1;i<=maxColumn;i++){
            dp[0][i] = 0;
        }
        int MODUL = 1000000007;
        for(int s = 1;s<=steps;s++){
            for(int c = 0;c<=maxColumn;c++){
                dp[s][c] = dp[s-1][c];
                if(c>0){
                    dp[s][c] = (dp[s][c] + dp[s-1][c-1])%MODUL;
                }
                if(c<maxColumn){
                    dp[s][c] = (dp[s][c] + dp[s-1][c+1])%MODUL;
                }
            }
        }
        return dp[steps][0];
    }
}
