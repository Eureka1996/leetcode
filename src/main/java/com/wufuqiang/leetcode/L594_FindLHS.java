package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L594_FindLHS {
    public int findLHS(int[] nums) {
        int leftCount = 0;
        int rightCount = 0;
        Map<Integer,Integer> mapTmp = new HashMap<>();
        for(int num : nums){
            Integer count = mapTmp.getOrDefault(num, 0);
            count+=1;
            mapTmp.put(num,count);
            Integer leftCountTmp = mapTmp.getOrDefault(num - 1, -count);
            Integer rightCountTmp = mapTmp.getOrDefault(num + 1, -count);
            leftCount = Math.max(leftCount,leftCountTmp+count);
            rightCount = Math.max(rightCount,rightCountTmp+count);
        }

        return Math.max(leftCount,rightCount);
    }
}
