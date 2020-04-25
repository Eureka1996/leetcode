package com.wufuqiang.leetcode;
//求不重复的两个数，与L260相似
public class MS17_19_MissingTwo {
	public int[] missingTwo(int[] nums) {
		int bitmask = 0;
		int n = nums.length;
		for(int i = 1;i<=n;i++){
			bitmask^=i;
			bitmask^=nums[i-1];
		}
		bitmask^=(n+1);
		bitmask^=(n+2);

		//获取最右边的1
		int diff = bitmask & (-bitmask);
		int x = 0;
		for(int i = 1;i<=n;i++){
			if((i&diff) != 0){
				x ^= i;
			}
			if((nums[i-1] & diff) != 0){
				x ^= nums[i-1];
			}
		}
		if(((n+1)&diff) != 0) x ^= (n+1);
		if(((n+2)&diff) != 0) x ^= (n+2);
		int y = bitmask^x;
		return new int[]{x,y};
	}
}
