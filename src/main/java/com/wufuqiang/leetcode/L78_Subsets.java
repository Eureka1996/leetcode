package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//子集
public class L78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(result,path,nums,0);
        return result;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> path,int[] nums,int begin){
        res.add(new ArrayList<>(path));

        for(int i = begin;i<nums.length;i++){
            path.add(nums[i]);
            backtrack(res,path,nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
