package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//有向无环图 所有可能的路径 回溯算法
public class L797_AllPathsSourceTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		List<List<Integer>> res = new ArrayList<>();
		if(graph == null || graph.length == 0) return res;
		List<Integer> path = new ArrayList<>();
		path.add(0);
		backtrack(res,path,graph,0);
		return res;
	}

	public void backtrack(List<List<Integer>> res,List<Integer> path,int[][] graph,int index){
		if(path.get(path.size()-1).equals(graph.length-1)){
			res.add(new ArrayList<>(path));
			return;
		}

		for(int next : graph[index]){

			path.add(next);
			backtrack(res,path,graph,next);
			path.remove(path.size()-1);
		}
	}
}
