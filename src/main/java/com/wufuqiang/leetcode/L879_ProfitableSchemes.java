package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-09 00:30
 */
public class L879_ProfitableSchemes {
    public static void main(String[] args) {

    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int MOD = (int)1e9 + 7;
        int[][][] dp = new int[len+1][n+1][minProfit+1];
        dp[0][0][0] = 1;

        for(int i = 1;i<=len;i++){
            int members = group[i-1];
            int earn = profit[i-1];
            for(int j =0;j<=n;j++){
                for(int z =0;z<=minProfit;z++){
                    if(j<members){
                        dp[i][j][z] = dp[i - 1][j][z];
                    }else{
                        dp[i][j][z] = (dp[i - 1][j][z] + dp[i - 1][j - members][Math.max(0, z - earn)]) % MOD;
                    }
                }
            }
        }


        int sum = 0;
        for(int j=0;j<=n;j++){
            sum = (sum+dp[len][j][minProfit])%MOD;
        }
        return sum;
    }

}
