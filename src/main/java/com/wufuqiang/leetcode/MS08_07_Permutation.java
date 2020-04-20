package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MS08_07_Permutation {

    public String[] permutation(String S) {
        List<String> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        boolean[] used = new boolean[chars.length];
        backtrack(result,chars,new char[chars.length],0,used);
        return result.toArray(new String[result.size()]);
    }

    public void backtrack(List<String> result,char[] chars,char[] path,int pathLen,boolean[] used){
        if(pathLen == path.length){
            result.add(String.valueOf(path));
            return;
        }
        for(int i = 0;i<chars.length;i++){
            if(used[i]) continue;
            path[pathLen] = chars[i];
            used[i] = true;
            backtrack(result,chars,path,pathLen+1,used);
            used[i] = false;
            path[pathLen] = '\0';
        }
    }

    public static void main(String[] args) {
        MS08_07_Permutation ms08 = new MS08_07_Permutation();
        String[] strs = ms08.permutation("abc");
        for(String str:strs){
            System.out.println(str);
        }
    }
}
