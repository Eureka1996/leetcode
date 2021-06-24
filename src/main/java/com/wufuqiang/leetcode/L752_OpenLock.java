package com.wufuqiang.leetcode;

import java.util.*;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-25 00:29
 */
public class L752_OpenLock {
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target)) return 0;

        Set<String> dead = new HashSet<>();
        for (String end:deadends) dead.add(end);
        if(dead.contains("0000")) return -1;
        int step = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.offerLast("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        while (!queue.isEmpty()){
            step+=1;
            int size = queue.size();
            for(int i = 0;i<size;i++){
                String current = queue.pollFirst();
                for(String next : get(current)){
                    if(!dead.contains(next) && !seen.contains(next)){
                        if(target.equals(next)) return step;
                        queue.offerLast(next);
                        seen.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> get(String status){
        List<String> res = new ArrayList<>();
        char[] statusChars = status.toCharArray();
        for(int i = 0;i<4;i++){
            char tmp = statusChars[i];
            statusChars[i] = getPre(tmp);
            res.add(new String(statusChars));
            statusChars[i] = getNext(tmp);
            res.add(new String(statusChars));
            statusChars[i] = tmp;
        }
        return res;
    }

    public char getPre(char x){
        return x=='0'?'9':(char)(x-1);
    }

    public char getNext(char x){
        return x == '9'?'0':(char)(x+1);
    }
}
