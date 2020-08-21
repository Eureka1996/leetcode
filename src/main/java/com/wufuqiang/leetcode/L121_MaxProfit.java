package com.wufuqiang.leetcode;

/**
 * 买卖股票的最佳时机
 */
public class L121_MaxProfit {
	/**
	 * 一次遍历
	 * @param prices
	 * @return
	 */
	public int maxProfit(int prices[]) {
		//记录当前的最低点
		int minprice = Integer.MAX_VALUE;
		//记录最大收益
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			//如果当前值小于最低点，则更新最低点
			if (prices[i] < minprice)
				minprice = prices[i];
			else if (prices[i] - minprice > maxprofit)
				maxprofit = prices[i] - minprice;
		}
		return maxprofit;
	}
}
