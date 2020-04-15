package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//组合总和
public class L40_CombinationSum2 {
    public static void main(String[] args) {
        L40_CombinationSum2 l39 = new L40_CombinationSum2();
        List<List<Integer>> result = l39.combinationSum(new int[]{2,5,2,3,1,2,2,2,2,2,2},6);
        System.out.println("------------------------------");

        for(List<Integer> list : result){
            for(int i : list){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result,path,candidates,0,target,0);
        return result;
    }

    public void backtrack(List<List<Integer>> result,List<Integer> path,int[] candidates,int startIndex,int target,int sum){
        if(sum == target ){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i<candidates.length;i++){
            if(i>startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            sum+=candidates[i];
            if(sum>target){
                sum-=candidates[i];
                break;
            }
            path.add(candidates[i]);
            backtrack(result,path,candidates,i+1,target,sum);
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }
}
