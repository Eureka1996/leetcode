package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L228_SummaryRanges {
	public List<String> summaryRanges(int[] nums) {

		List<String> result = new ArrayList<>();
		if(nums == null || nums.length==0){
			return result;
		}
		int start = 0;
		int end = 0;

		for(int i = 1;i<nums.length;i++){
			if(nums[i]-nums[i-1]==1){
				end+=1;
			}else{
				if(start==end){
					result.add(String.format("%d",nums[start]));
				}else{
					result.add(String.format("%d->%d",nums[start],nums[end]));
				}

				start = i;
				end = i;
			}
		}
		if(start==end){
			result.add(String.format("%d",nums[start]));
		}else{
			result.add(String.format("%d->%d",nums[start],nums[end]));
		}
		return result;
	}
}
