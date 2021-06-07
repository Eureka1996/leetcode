package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-07 13:40
 */
public class L494_FindTargetSumWays {
//    private int sum = 0;
    private int count = 0;

    public static void main(String[] args) {
        L494_FindTargetSumWays l = new L494_FindTargetSumWays();
        int[] nums = new int[]{1,1,1,1,1};
        int targetSumWays2 = l.findTargetSumWays2(nums, 3);
        System.out.println(targetSumWays2);

    }
    //回溯解法
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,0,target,0);
        return count;
    }

    public void backtrack(int[] nums,int index,int target,int sum){
        if(nums.length <= index) {
            if(sum == target) count+=1;
            return;
        }
        backtrack(nums,index+1,target,sum+nums[index]);
        backtrack(nums,index+1,target,sum-nums[index]);
    }

    //动态规则解法
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for(int n : nums) sum+=n;
        int neg = sum - target;
        if(neg < 0 || (neg & 1) == 1) return 0;
        neg = neg>>1;
        int[][] dp = new int[nums.length+1][neg+1];
        dp[0][0] = 1;
        for(int i = 0;i<=nums.length;i++){
            for(int j = 0;j<=neg;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
        for(int i = 1;i<=nums.length;i++){
            for(int j = 0;j<=neg;j++){
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i][j]+dp[i-1][j-nums[i-1]];
                }
            }

        }
        for(int i = 0;i<=nums.length;i++){
            for(int j = 0;j<=neg;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[nums.length][neg];
    }

    //动态规则解法
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for(int n : nums) sum+=n;
        int neg = sum - target;
        if(neg < 0 || (neg & 1) == 1) return 0;
        neg = neg>>1;
        int[] dp = new int[neg+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }


}
