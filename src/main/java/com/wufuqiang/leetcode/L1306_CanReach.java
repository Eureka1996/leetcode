package com.wufuqiang.leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class L1306_CanReach {
	public boolean canReach(int[] arr, int start) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offerLast(start);

		HashSet<Integer> visited = new HashSet<>();
		boolean result = false;
		while(!queue.isEmpty()){
			int index = queue.pollFirst();
			if(arr[index] == 0){
				result = true;
				break;
			}
			visited.add(index);
			int leftIndex = index - arr[index];
			if(leftIndex>=0 && !visited.contains(leftIndex)){
				queue.offerLast(leftIndex);
			}
			int rightIndex = index+arr[index];
			if(rightIndex<arr.length && !visited.contains(rightIndex)){
				queue.offerLast(rightIndex);
			}
		}
		return result;
	}
}
