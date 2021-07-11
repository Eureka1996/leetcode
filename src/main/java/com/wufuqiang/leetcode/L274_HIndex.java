package com.wufuqiang.leetcode;

import java.util.Arrays;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-11 13:44
 */
public class L274_HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
