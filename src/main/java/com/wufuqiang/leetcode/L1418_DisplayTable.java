package com.wufuqiang.leetcode;

import java.util.*;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-06 18:26
 */
public class L1418_DisplayTable {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodnames = new HashSet<>();
        Map<Integer,Map<String,Integer>> foodsCnt = new HashMap<>();
        for(List<String> order:orders){
            foodnames.add(order.get(2));
            int tablenum = Integer.parseInt(order.get(1));
            Map<String, Integer> tableCnt = foodsCnt.getOrDefault(tablenum, new HashMap<>());
            tableCnt.put(order.get(2),tableCnt.getOrDefault(order.get(2),0)+1);
            foodsCnt.put(tablenum,tableCnt);
        }

        List<String> foodnamesList = new ArrayList<>();
        foodnames.forEach(name->foodnamesList.add(name));
        Collections.sort(foodnamesList);

        List<Integer> tablenums = new ArrayList<>();
        foodsCnt.keySet().forEach(tablenum->tablenums.add(tablenum));
        Collections.sort(tablenums);

        List<List<String>> table = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");

        foodnamesList.forEach(name -> header.add(name));
        table.add(header);

        tablenums.forEach(num->{
            Map<String, Integer> cnt = foodsCnt.get(num);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(num));
            foodnamesList.forEach(foodname -> {
                row.add(Integer.toString(cnt.getOrDefault(foodname,0)));
            });
            table.add(row);
        });
        return table;
    }
}
