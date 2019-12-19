package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author wufuqiang
 * @ date 2019/12/19/019 - 21:40
 **/
public class L1128_NumEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {

        Map<String,Integer> map = new HashMap<String,Integer>();
        String format = "%d%d";
        for(int[] dom:dominoes){
            String combined = "";
            if(dom[0] > dom[1]){
                combined = String.format(format,dom[1],dom[0]);
            }else{
                combined = String.format(format,dom[0],dom[1]);
            }
            Integer count = map.getOrDefault(combined, 0);
            count+=1;
            map.put(combined,count);
        }
        int resultCount = 0;
        for(Integer mapCount : map.values()){
            resultCount+=(mapCount*(mapCount-1)/2);
        }

        return resultCount;
    }

}
