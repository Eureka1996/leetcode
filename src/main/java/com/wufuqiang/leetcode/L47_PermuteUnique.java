package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//全排列
public class L47_PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(result,new ArrayList<Integer>(),nums,used);
        return result;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> path,
                          int[] nums,boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]) continue;

            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(res,path,nums,used);
            used[i] = false;
            path.remove(path.size()-1);
        }

    }
}
