package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//排列
public class L526_CountArrangement {
    int res = 0;
    public int countArrangement(int N) {
        List<Integer> path = new ArrayList<>();
        backtrack(path,N,0,0);
        return res;
    }

    public void backtrack(List<Integer> path, int N, int i, int value){
        if(path.size() > 0 && i%value != 0 && value % i != 0){
            return;
        }
        if(path.size() == N){
            res+=1;
            return;
        }

        for(int j =1;j<=N;j++){
            if(!path.contains(j)){
                path.add(j);
                backtrack(path,N,path.size(),j);
                path.remove(path.size()-1);
            }
        }
    }
}
