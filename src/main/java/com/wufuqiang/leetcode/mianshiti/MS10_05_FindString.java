package com.wufuqiang.leetcode.mianshiti;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-02 17:26
 */
public class MS10_05_FindString {
    public int findString(String[] words, String s) {
        int n = words.length;
        int l = 0;
        int r = n;
        while(l < r){
            int m = (r-l)/2 + l;
            int t = m;
            while(m < r && "".equals(words[m])) m+=1;
            if(r == m){
                r = t;
                continue;
            }
            if(words[m].equals(s)) return m;
            else if(words[m].compareTo(s) > 0) r = m;
            else l=m+1;
        }
        return -1;
    }
}
