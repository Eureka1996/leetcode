package com.wufuqiang.leetcode;

import java.util.*;

public class L997_FindJudge {
	public int findJudge(int N, int[][] trust) {
		if(trust == null || trust.length == 0){
			if(N == 1){
				return 1;
			}else{
				return -1;
			}
		}
		Map<Integer, Set<Integer>> mapJudge = new HashMap<>();
		Set<Integer> notJudge = new HashSet<Integer>();
		for(int[] t:trust){
			mapJudge.remove(t[0]);
			notJudge.add(t[0]);
			if(!notJudge.contains(t[1])){
				Set<Integer> set = mapJudge.getOrDefault(t[1],new HashSet<>());
				set.add(t[0]);
				mapJudge.put(t[1],set);
			}
		}
		if(mapJudge.size()==1){
			int judge = mapJudge.keySet().iterator().next();
			if(mapJudge.get(judge).size() == N-1){
				return judge;
			}
		}
		return -1;
	}
}
