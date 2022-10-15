package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2022-10-15 21:08
 *
 * 用栈操作构建数组
 */
public class L1441_BuildArray {
    public static void main(String[] args) {
        L1441_BuildArray l = new L1441_BuildArray();
        List<String> resultList = l.buildArray(new int[]{1, 3}, 3);
        System.out.println(resultList);
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int index = 1;
        for (int t : target) {
            while(index < t){
                result.add("Push");
                result.add("Pop");
                index+=1;
            }
            result.add("Push");
            index+=1;
        }
        return result;
    }
}
