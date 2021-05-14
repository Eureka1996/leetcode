package com.wufuqiang.leetcode;

import java.util.*;

/**
 * 课程表
 * 拓扑排序
 */
public class L207_CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //用于记录每个课程的入度，数组索引为课程编号，值为入度
        int[] degrees = new int[numCourses];
        for(int[] p : prerequisites){
            degrees[p[0]] = degrees[p[0]]+1;
        }

        //用于记录入度为0的课程
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i<numCourses ;i++){
            if(degrees[i] == 0){
                queue.addLast(i);
            }
        }
        while(!queue.isEmpty()){
            Integer pre = queue.removeFirst();
            numCourses--;
            for(int[] p : prerequisites){
                if(p[1] != pre) continue;
                degrees[p[0]] = degrees[p[0]] -1;
                if(degrees[p[0]] == 0) queue.add(p[0]);
            }
        }
        return numCourses == 0;
    }

    public boolean canFinish02(int numCourses, int[][] prerequisites) {
        //用于记录每个课程的入度，数组索引为课程编号，值为入度
        int[] degrees = new int[numCourses];

        //key为课程编号，value为依赖它的课程编号
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites){
            degrees[p[0]] = degrees[p[0]]+1;
            List<Integer> c = map.getOrDefault(p[1], new ArrayList<>());
            c.add(p[0]);
            map.put(p[1],c);
        }

        //用于记录入度为0的课程
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i<numCourses ;i++){
            if(degrees[i] == 0){
                queue.addLast(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                Integer pre = queue.pollFirst();
                size--;
                numCourses--;
                List<Integer> cs = map.get(pre);
                if(cs == null) continue;
                for(int i:cs){
                    degrees[i]--;
                    if(degrees[i] == 0){
                        queue.offerLast(i);
                    }
                }
            }
        }
        return numCourses == 0;
    }



}
