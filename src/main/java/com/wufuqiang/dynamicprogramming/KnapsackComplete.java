package com.wufuqiang.dynamicprogramming;

/**
 * @author Wu Fuqiang
 * @date 2021/11/14 1:50 下午
 */
public class KnapsackComplete {
    public static void main(String[] args) {
        KnapsackComplete knapsack = new KnapsackComplete();
        int n = 4;
        int m = 5; 
        int[] costs = new int[]{2, 4, 4, 5};
        int[] volumes = new int[]{1, 2, 3, 4};

        final int res = knapsack.knapsackComplete(n, m, costs, volumes);
        System.out.println(res);

    }
    
    public int knapsackComplete(int n,int m,int[] cost,int[] volume){
        // dp[i]表示总体积是i的情况下，最大价值是多少
        int[] dp = new int[m+1];
        for(int i = 0;i<n;i++){
            for(int j = volume[i];j<=m;j++){
                /**
                 * dp[j - k*volume[i]]
                 * dp[j - k*volume[i] - volume[i]] +cost[i]
                 */
                dp[j] = Math.max(dp[j],dp[j-volume[i]] + cost[i]);
            }
        }
        return dp[m];
    }
    
    
}
