package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L387_FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character,Integer> tmp = new HashMap<Character, Integer>();

        for(char c : s.toCharArray()){
            int count = tmp.getOrDefault(c,0);
            count+=1;
            tmp.put(c,count);
        }
        for(int i = 0 ;i < s.length();i++){
            char c = s.charAt(i);
            if(tmp.get(c)==1){
                return i;
            }
        }

        return -1;
    }
}
