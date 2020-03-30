package com.wufuqiang.leetcode;

import java.util.*;

public class L1345_MinJumps {
	public static void main(String[] args) {
		L1345_MinJumps l1345 = new L1345_MinJumps();
		int result = l1345.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404});
		System.out.println("\n======="+result);
	}
	public int minJumps(int[] arr) {
		int result = -1;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0;i<arr.length;i++){
			List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
			list.add(i);
			map.put(arr[i],list);
		}
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offerLast(0);
		HashSet<Integer> visited = new HashSet<>();
		int stepCount = 1;
		while(!queue.isEmpty() && stepCount>0){
			int curStepCount = 0;
			result+=1;
			for(int i = 0;i<stepCount;i++){
				Integer index = queue.pollFirst();
				visited.add(index);
				System.out.print(index+"\t");
				if(index == arr.length-1){
					return result;
				}
				if(index-1>=0 && !visited.contains(index-1)){
					queue.offerLast(index-1);
					curStepCount+=1;
				}
				if(index+1<arr.length && !visited.contains(index+1)){
					queue.offerLast(index+1);
					curStepCount+=1;
				}
				if(map.containsKey(arr[index])){
					List<Integer> otherIndexes= map.get(arr[index]);
					for(int otherIndex : otherIndexes){
						if(!visited.contains(otherIndex)){
							queue.offerLast(otherIndex);
							curStepCount+=1;
						}
					}
					map.remove(arr[index]);
				}


			}
			System.out.println();
			stepCount = curStepCount;
		}
		return result;
	}
}
