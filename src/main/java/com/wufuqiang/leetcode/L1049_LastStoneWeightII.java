package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-08 00:41
 */
public class L1049_LastStoneWeightII {
    public static void main(String[] args) {

    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int s : stones) sum+=s;
        int neg = sum/2;
        boolean[][] dp = new boolean[stones.length+1][neg+1];
        dp[0][0] = true;
        for(int i = 0;i<stones.length;i++){
            for(int j =0;j<= neg;j++){
                if(j < stones[i]){
                    dp[i+1][j] = dp[i][j];
                }else{
                    dp[i+1][j] = dp[i][j] || dp[i][j-stones[i]];
                }
            }
        }
        for(int j = neg;;j--){
            if(dp[stones.length][j]){
                return sum - 2*j;
            }
        }
    }
    public int lastStoneWeightII2(int[] stones) {
        int sum = 0;
        for(int s : stones) sum+=s;
        int neg = sum/2;
        boolean[] dp = new boolean[neg+1];
        dp[0] = true;
        for(int i = 0;i<stones.length;i++){
            for(int j =neg;j>=stones[i];j--){
                dp[j] = dp[j] || dp[j-stones[i]];
            }
        }
        for(int j = neg;;j--){
            if(dp[j]){
                return sum - 2*j;
            }
        }
    }
}
