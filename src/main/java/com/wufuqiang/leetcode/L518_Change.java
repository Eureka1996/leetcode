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
}
