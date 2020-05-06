package com.wufuqiang.leetcode;
//动态规划 最低票价
public class L983_MincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0 || costs == null || costs.length == 0) return 0;
        return mincost(days,costs);
    }

    public int mincost(int[] days,int[] costs){
        int[] durations = {1,7,30};
        Integer[] dp = new Integer[days.length];
        int minCost = Integer.MAX_VALUE;
        for(int i = days.length-1;i>=0;i--){
            minCost = Integer.MAX_VALUE;
            for(int k = 0;k<3;k++){

                int j = i+1;
                int nextDay = days[i]+durations[k];
                while(j<days.length && days[j] < nextDay ){
                    j++;
                }
                if(j>=days.length){
                    minCost = Math.min(costs[k],minCost);
                }else{
                    minCost = Math.min(costs[k]+dp[j],minCost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0];
    }
}
