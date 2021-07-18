package com.wufuqiang.leetcode.mianshiti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-18 21:13
 */
public class MS10_02_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for(int i=0;i<str.length();i++){
                counts[str.charAt(i)-'a']+=1;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<26;i++){
                if(counts[i] > 0){
                    sb.append((char)('a'+i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
