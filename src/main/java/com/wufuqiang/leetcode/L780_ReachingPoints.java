package com.wufuqiang.leetcode;

import java.util.*;

public class L780_ReachingPoints {
	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		return bfs(sx,sy,tx,ty);
	}

	//超时
	public boolean bfs(int sx,int sy,int tx,int ty){
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offerLast(new int[]{sx,sy});

		Set<List<Integer>> visited = new HashSet<>();
		while(!queue.isEmpty()){
			int[] q = queue.pollFirst();
			visited.add(Arrays.<Integer>asList(q[0],q[1]));
			if(q[0] == tx && q[1] == ty){
				return true;
			}
			int nxy = q[0] + q[1];
			if(!visited.contains(Arrays.<Integer>asList(q[0],nxy))){
				queue.offerLast(new int[]{q[0],nxy});
			}
			if(!visited.contains(Arrays.<Integer>asList(nxy,q[1]))){
				queue.offerLast(new int[]{nxy,q[1]});
			}
		}
		return false;
	}
}
