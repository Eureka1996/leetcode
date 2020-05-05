package com.wufuqiang.leetcode;

import java.util.*;
//递增子序列
public class L491_FindSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		backtrack(result,path,nums,0);
		return result;
	}

	public void backtrack(List<List<Integer>> result,List<Integer> path,int[] nums,int begin){
		if(path.size()>1) {
			result.add(new ArrayList<>(path));
		}

		Set<Integer> used = new HashSet<>();
		for(int i = begin;i<nums.length;i++){

			if(!used.contains(nums[i]) && (path.size() == 0 || path.get(path.size()-1) <= nums[i])){
				used.add(nums[i]);
				path.add(nums[i]);
				backtrack(result,path,nums,i+1);
				path.remove(path.size()-1);
			}
		}

	}
}
