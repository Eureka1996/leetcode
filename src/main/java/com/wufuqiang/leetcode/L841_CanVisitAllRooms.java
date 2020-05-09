package com.wufuqiang.leetcode;

import com.sun.deploy.panel.RuleSetViewerDialog;

import java.util.LinkedList;
import java.util.List;
//深度优先搜索 钥匙和房间
public class L841_CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return true;
        boolean[] used = new boolean[rooms.size()];
        used[0] = true;
        LinkedList<Integer> nextRooms = new LinkedList<>();
        nextRooms.offerLast(0);
        int count = 1;
        while(!nextRooms.isEmpty()){
            int nextRoom = nextRooms.pollFirst();
            for(int room : rooms.get(nextRoom)){
                if(!used[room]){
                    nextRooms.offerLast(room);
                    used[room] = true;
                    count+=1;
                }
            }
        }
        return count == rooms.size()?true:false;
    }

}
