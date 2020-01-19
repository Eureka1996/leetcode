package com.wufuqiang.leetcode;

public class L322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return 0;
        }
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i<=amount;i++){
            int min = -1;
            for(int coin : coins){
                if(i-coin >= 0){
                    int tmp = dp[i-coin];
                    if(tmp != -1){
                        if(min == -1){
                            min = tmp + 1;
                        }else{
                            min = Math.min(tmp+1,min);
                        }
                    }
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
