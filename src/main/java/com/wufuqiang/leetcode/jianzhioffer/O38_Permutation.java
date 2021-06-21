package com.wufuqiang.leetcode.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-22 00:41
 */
public class O38_Permutation {
    public static void main(String[] args) {

    }
    public String[] permutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        backtrack(ans,chars,new char[chars.length],0,used);
        return ans.toArray(new String[ans.size()]);
    }

    private void backtrack(List<String> result,char[] chars,char[] path,int index,boolean[] used){
        if(chars.length == index){
            result.add(new String(path));
            return ;
        }
        for(int i = 0;i<chars.length;i++){
            if(used[i]) continue;
            if(i>0 && chars[i] == chars[i-1] && !used[i-1]) continue;
            used[i] = true;
            path[index] = chars[i];
            backtrack(result,chars,path,index+1,used);
            path[index] = '\0';
            used[i] = false;
        }

    }
}
