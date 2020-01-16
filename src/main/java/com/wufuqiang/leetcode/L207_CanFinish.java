package com.wufuqiang.leetcode;

import java.util.LinkedList;

public class L207_CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        for(int[] p : prerequisites){
            degrees[p[0]] = degrees[p[0]]+1;
        }
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
}
