package com.wufuqiang.leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class L55_CanJump {
	public boolean canJump(int[] nums) {
		if(nums == null || nums.length == 0){
			return true;
		}
		if(nums.length == 1){
			return true;
		}
		HashSet<Integer> set = new HashSet<>();
		set.add(0);
		boolean result = false;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offerLast(0);
		while(!queue.isEmpty()){
			int cur = queue.pollFirst();
			for(int i = 1;i<=nums[cur];i++){
				int index = cur+i;
				if(index==nums.length-1){
					result=true;
					return result;
				}
				if(index<nums.length && !set.contains(index)){
					queue.offerLast(index);
					set.add(index);
				}
			}
		}
		return result;
	}

	public boolean canJump2(int[] nums) {
		boolean result = false;
		int index = 0;
		for(int i = 0;i<nums.length;i++){
			if(index<i){
				result = false;
				break;
			}
			int nextIndex = nums[i] + i;
			if(nextIndex>index){
				index = nextIndex;
			}
			if(index>=nums.length-1){
				result = true;
				break;
			}
		}
		return result;
	}
}
