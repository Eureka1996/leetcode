package com.wufuqiang.leetcode;

public class L45_Jump {
	public int jump(int[] nums) {

		int count = 0;
		int stepRegion = 0;
		int index = 0;
		for(int i = 0;i<nums.length;i++){
			if(i>stepRegion){
				count+=1;
				stepRegion=index;
			}

			int nextIndex = nums[i]+i;
			if(nextIndex>index){
				index = nextIndex;
			}
			if(nextIndex>=nums.length-1){
				count+=1;
				break;
			}
		}

		return count;
	}
}
