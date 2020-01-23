package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author wufuqiang
 **/
public class L1018_PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int sum = 0;
        List<Boolean> result = new ArrayList<Boolean>();
        for(int a : A){
            sum = sum * 2 + a;
            if(sum % 5 == 0){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}
