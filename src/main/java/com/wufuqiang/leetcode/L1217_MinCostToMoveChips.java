package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 **/
public class L1217_MinCostToMoveChips {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for(int chip :chips){
            if(chip % 2 == 0){
                even+=1;
            }else{
                odd+=1;
            }
        }
        return Math.min(odd,even);
    }
}
