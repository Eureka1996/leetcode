package com.wufuqiang.leetcode;
////求不重复的两个数，与MS17.19相似
public class L260_SingleNumber {
	public int[] singleNumber(int[] nums) {
		int bitmask = 0;
		//获取两个只出现一次的数字的异或值
		for(int i : nums){
			bitmask ^= i;
		}
		//获取最右边的1
		int diff = bitmask & (-bitmask);
		int x = 0;
		for(int i : nums){
			if((i&diff)!=0){
				x^=i;
			}
		}
		int y = bitmask ^ x;
		return new int[]{x,y};
	}
}
