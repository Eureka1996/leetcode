package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-10 00:24
 */
public class L518_Change {
    public static void main(String[] args) {

    }
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int a = coin;a<= amount;a++){
                dp[a] += dp[a-coin];
            }
        }
        return dp[amount];
    }

    /**
     * 二维数组解法
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0 ;i<= amount;i++){
            dp[0][i] = 0;
        }
        for(int i = 0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i<= n;i++){
            for(int j = 1;j<= amount;j++){
                dp[i][j] = dp[i-1][j];
                if(j-coins[i-1] >= 0)
                    dp[i][j] += dp[i][j-coins[i-1]];
            }
        }
        return dp[n][amount];
    }

    public int change3(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0;i<n;i++){
            for(int a = coins[i];a<= amount;a++){
                dp[a] += dp[a-coins[i]];
            }
        }
        return dp[amount];
    }
}
