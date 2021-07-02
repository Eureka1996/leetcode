package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-02 10:51
 */
public class L1833_MaxIceCream {

    public static void main(String[] args) {

        int[] costs = new int[]{1,3,2,4,1};
        int coins = 7;

        L1833_MaxIceCream l = new L1833_MaxIceCream();
        int i = l.maxIceCream(costs, coins);
        System.out.println(i);

    }

    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int[][] dp = new int[n+1][coins+1];
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=coins;j++){
                dp[i][j] = dp[i-1][j];
                if(j-costs[i-1] >= 0){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-costs[i-1]]+1);
                }
            }
        }
        return dp[n][coins];
    }

    public int maxIceCream2(int[] costs, int coins) {
        int res = 0;
        Arrays.sort(costs);
        int curCoins = coins;
        for(int cost:costs){
            if(curCoins - cost >= 0 ){
                res += 1;
                curCoins-= cost;
            }else{
                break;
            }
        }
        return res;
    }



}
