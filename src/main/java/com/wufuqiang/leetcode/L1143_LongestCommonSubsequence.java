package com.wufuqiang.leetcode;
//最长公共子序列
public class L1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //初始化第一行
        for(int i = 0 ;i<dp[0].length;i++) dp[0][i] = 0;
        for(int i = 0;i<dp.length;i++) dp[i][0] = 0;
        for(int i = 1;i<dp.length;i++){
            for(int j = 1; j < dp[0].length;j++){
                char c1 = text1.charAt(i-1);
                char c2 = text2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
