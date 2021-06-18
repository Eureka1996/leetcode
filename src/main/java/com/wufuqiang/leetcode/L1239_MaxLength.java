package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-19 00:32
 */
public class L1239_MaxLength {
    public static void main(String[] args) {

    }
    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for(String s : arr){
            int mask = 0;
            for(int i = 0;i<s.length();i++){
                int ch = s.charAt(i)-'a';
                if(((mask >> ch) & 1) == 1){
                    mask = 0;
                    break;
                }
                mask |= (1 << ch);
            }
            if(mask > 0){
                masks.add(mask);
            }
        }
        backtrack(masks,0,0);
        return ans;
    }

    public void backtrack(List<Integer> masks ,int index ,int mask){
        if(index == masks.size()){
            ans = Math.max(ans,Integer.bitCount(mask));
            return ;
        }
        int m = masks.get(index);
        if((m & mask) == 0){
            backtrack(masks,index+1,mask | m);
        }
        backtrack(masks,index+1,mask);

    }
}
