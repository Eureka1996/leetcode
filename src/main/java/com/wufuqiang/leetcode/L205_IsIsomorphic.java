package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L205_IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        boolean flag = true;
        for(int i = 0;i<s.length();i++){
            char sc = s.charAt(i);
            set.add(t.charAt(i));
            if(map.containsKey(sc)){
                int index = map.get(sc);
                if(t.charAt(i) != t.charAt(index)){
                    flag =false;
                    break;
                }
            }
            map.put(sc,i);
        }
        if(flag && set.size() != map.size()) flag = false;
        return flag;
    }
    public boolean isIsomorphic2(String s, String t) {
        char[] mapS = new char[128];
        boolean[] mapT = new boolean[128];

        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (mapS[sArr[i]] != '\0' || mapT[tArr[i]] == true) {
                if (mapS[sArr[i]] != tArr[i])
                    return false;
            }
            else {
                mapS[sArr[i]] = tArr[i];
                mapT[tArr[i]] = true;
            }
        }
        return true;
    }
}
