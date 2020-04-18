package com.wufuqiang.leetcode;
//最大容器
public class L11_MaxArea {
	public int maxArea(int[] height) {
		int area = 0;
		int low = 0;
		int high = height.length-1;
		while(low<high){
			int m = Math.min(height[low],height[high]);
			if(area < m*(high-low)){
				area = m*(high-low);
			}
			if(m==height[low]){
				low+=1;
			}else{
				high-=1;
			}
		}
		return area;
	}
}
