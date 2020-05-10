package com.wufuqiang.leetcode;
//重复的数字
public class MS03_FindRepeatNumber {
	public int findRepeatNumber(int[] nums) {
		int result = -1;
		int tmp = 0;
		for(int i = 0;i<nums.length;i++){
			while(nums[i] != i){
				if(nums[i] == nums[nums[i]]){
					result = nums[i];
					break;
				}
				tmp = nums[i];
				nums[i] = nums[tmp];
				nums[tmp] = tmp;
			}
		}
		return result;
	}
}
