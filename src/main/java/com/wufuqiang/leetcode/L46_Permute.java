package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//全排列
public class L46_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(result,path,nums);
        return result;

    }

    public void backtrack(List<List<Integer>> res,List<Integer> path,int[] nums){
        //判断是否满足结束条件
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int n : nums){
            if(!path.contains(n)){
                path.add(n);
                backtrack(res,path,nums);
                path.remove(path.size()-1);
            }
        }
    }
}
