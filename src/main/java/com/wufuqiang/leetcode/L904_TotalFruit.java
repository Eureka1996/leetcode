package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-13 14:36
 */
public class L904_TotalFruit {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] tree) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = 0;
        int resultTmp = 0;
        for(int i = 0;i<tree.length;i++){
            if(map.containsKey(tree[endIndex])){
                Integer integer = map.get(tree[endIndex]);
                integer++;
                map.put(tree[endIndex],integer);
                resultTmp++;
            }else{
                if(map.size() >=2){
                    result = Math.max(result,resultTmp);
                    resultTmp = 0;
                    int mapVal = map.get(tree[startIndex]);
                    while(mapVal > 0){
                        mapVal--;
                        map.put(tree[startIndex],mapVal);
                        startIndex++;
                        mapVal = map.get(tree[startIndex]);
                    }
                    map.remove(tree[startIndex]);
                }
                map.put(tree[endIndex],1);
                resultTmp++;
            }
            endIndex++;
        }
        return result;
    }
}
