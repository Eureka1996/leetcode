package com.wufuqiang.leetcode;
//最大容器
//盛最多水的容器
public class L11_MaxArea {
	public int maxArea(int[] height) {
		//记录最终的结果
		int area = 0;
		int low = 0;
		int high = height.length-1;
		while(low<high){
			//此时两根柱子能接往水的高度
			int m = Math.min(height[low],height[high]);
			if(area < m*(high-low)){
				area = m*(high-low);
			}
			//哪边矮移动哪一边
			if(m==height[low]){
				low+=1;
			}else{
				high-=1;
			}
		}
		return area;
	}
}
