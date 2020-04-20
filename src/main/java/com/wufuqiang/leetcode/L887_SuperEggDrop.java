package com.wufuqiang.leetcode;
//鸡蛋掉落
public class L887_SuperEggDrop {
	public int superEggDrop(int K, int N) {
		// dp 数组的含义：用 i 个鸡蛋测试 j 次最多能测试 n 层楼
		// 初始化最左侧（0层楼）为 0，最上层（0个鸡蛋）为0
		int[][] dp = new int[K+1][N+1];

		// 每次扔一个鸡蛋就把楼层分成两部分
		// 如果鸡蛋没碎，就是用 i 个鸡蛋测试 j-1 次的最大楼层
		// 如果鸡蛋碎了，就是 i-1 个鸡蛋测试 j-1 次的最大楼层
		// 加上鸡蛋本身就能测出来一层
		// 递推公式就出来了，如下

        /*
        或者换一种说法
        假设我们知道了
            i 个鸡蛋测试 j-1 次可以测试 k1 层楼
            i-1 个鸡蛋测试 j-1 次可以测试 k2 层楼

        那么我们用 i 个鸡蛋测试 j 次可以测试 k1 + k2 + 1 层楼
        因为我们第一次可以在第 k2 + 1 层扔鸡蛋
            如果碎了，我们就可以用剩下的 i-1 个鸡蛋测试 j-1 次验证下面的 k2 层楼
            如果没碎，我们就用 i 个鸡蛋测试 j-1 次验证上面的 k1 层楼
        */
		for(int j = 1 ; j<=N;j++){
			for(int i = 1; i<=K;i++){
				dp[i][j] = dp[i][j-1] + dp[i-1][j-1] + 1;
				if(dp[i][j] >= N) return j;
			}
		}

		return N;
	}
}
