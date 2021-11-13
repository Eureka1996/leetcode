package com.wufuqiang.dynamicprogramming;

/**
 * 0-1背包问题
 */
public class Knapsack01 {

	public static void main(String[] args) {
		Knapsack01 knapsack01 = new Knapsack01();
		int n = 4;
		int m = 5;
		int[] costs = new int[]{2, 4, 4, 5};
		int[] volumes = new int[]{1, 2, 3, 4};
		
		int res1 = knapsack01.knapsack01(n,m,costs,volumes);
		System.out.println(res1);
		
		int res = knapsack01.knapsack02(4, 5,new int[]{2, 4, 4, 5}, new int[]{1, 2, 3, 4});
		System.out.println(res);
	}


	/**
	 * 采用二维数组做动态规划
	 *
	 * @param n 总物品个数
	 * @param m 背包容量
	 * @param cost 各个物品的价值,index=0时为第一个物品
	 * @param volume 各个物品的容量,index=0时为第一个物品
	 */
	public int knapsack01(int n,int m,int[] cost,int[] volume){
		//每行表示考虑到第i个物品，每列表示背包有多少容量
		// dp[i][j]表示只看前i个物品，总体积是j的情况下，总价值最大是多少。
		int[][] dp = new int[n+1][m+1];
		// i=0时，表示没有物品，所以所有值为0
		// j=0时，表示背包容量为0，所以所有值为0
		for(int i = 1;i<=n;i++){
			for(int j = 1;j<=m;j++){
				//不选第i个物品，即当前物品
				dp[i][j] = dp[i-1][j];
				// volumn[i-1]表示第i个物品的容量
				if(j-volume[i-1]>=0){ // 判断是否有足够容量选第i个物品
					//选第i个物品
					dp[i][j] = Math.max(dp[i][j],cost[i-1]+dp[i-1][j-volume[i-1]]);
				}
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		int res = 0;
		//判断最后一行，即有n个物品的情况下，哪种情况下背包装的价值最大
		for(int i = 0;i<=m;i++){
			res = Math.max(res,dp[n][i]);
		}
		return res;
	}

	/**
	 * 采用一维数组做动态规划
	 *
	 * @param n 总物品个数
	 * @param m 背包容量
	 * @param cost 各个物品的价值,index=0时为第一个物品
	 * @param volume 各个物品的容量,index=0时为第一个物品
	 */
	public int knapsack02(int n,int m,int[] cost,int[] volume){
		int[] dp = new int[m+1];
		for(int i = 1;i<=n;i++){
			//从后往前遍历，原有的数据是i-1个物品时的情况
			for(int j = m;j>=volume[i-1];j--){
				// dp[j]为不选的最大值
				dp[j] = Math.max(dp[j],dp[j-volume[i-1]]+cost[i-1]);
			}
		}
		return dp[m];
	}
}
