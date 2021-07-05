package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-05 12:40
 */
public class L726_CountOfAtoms {
    private int i;
    private int n;
    private String formula;
    public String countOfAtoms(String formula) {
        this.i =0;
        this.n = formula.length();
        this.formula = formula;

        LinkedList<Map<String,Integer>> stack = new LinkedList<>();
        stack.offerFirst(new HashMap<String,Integer>());
        while(i < n){
            char ch = formula.charAt(i);
            if(ch == '('){
                i+=1;
                // 将一个空的哈希表压入栈中，准备统计括号内的原子数量。
                stack.offerFirst(new HashMap<>());
            }else if(ch == ')'){
                i+=1;
                int num = parseNum();
                Map<String,Integer> popMap = stack.pollFirst();
                Map<String,Integer> topMap = stack.peekFirst();

                popMap.forEach((key,value)->{
                    topMap.put(key,topMap.getOrDefault(key,0)+value*num);
                });

            }else{
                String atom = parseAtom();
                int num = parseNum();
                Map<String,Integer> topMap = stack.peekFirst();
                topMap.put(atom,topMap.getOrDefault(atom,0)+num);
            }
        }
        Map<String, Integer> topMap = stack.pollFirst();
        TreeMap<String, Integer> treeMap = new TreeMap<>(topMap);

        StringBuffer sb = new StringBuffer();

        treeMap.forEach((atom,count)->{
            sb.append(atom);
            if(count > 1) sb.append(count);
        });


        return sb.toString();
    }

    private String parseAtom(){
        StringBuffer sb = new StringBuffer();
        // 扫描首字母
        sb.append(formula.charAt(i));
        i+=1;
        while(i<n && Character.isLowerCase(formula.charAt(i))){
            sb.append(formula.charAt(i));
            i+=1;
        }
        return sb.toString();
    }

    private int parseNum(){
        if(i == n || !Character.isDigit(formula.charAt(i))){
            // 右侧不是数字，视为1
            return 1;
        }
        int num = 0;
        while(i < n && Character.isDigit(formula.charAt(i))){
            num = num * 10 + formula.charAt(i) - '0';
            i+=1;
        }
        return num;
    }



}
