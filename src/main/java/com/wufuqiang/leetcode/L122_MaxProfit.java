package com.wufuqiang.leetcode;
/**
 * 买卖股票的最佳时机 II
 */
public class L122_MaxProfit {
	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxprofit += prices[i] - prices[i - 1];
		}
		return maxprofit;
	}
}
