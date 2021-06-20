package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-21 00:33
 */
public class L401_ReadBinaryWatch {
    public static void main(String[] args) {
        L401_ReadBinaryWatch l = new L401_ReadBinaryWatch();
        List<String> ans = l.readBinaryWatch(1);
        System.out.println(ans);
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for(int hour = 0;hour<12;hour++){
            for(int minute=0;minute<60;minute++){
                if(Integer.bitCount(hour)+Integer.bitCount(minute) == turnedOn){
                    ans.add(String.format("%d:%02d",hour,minute));
                }
            }
        }
        return ans;
    }
}
