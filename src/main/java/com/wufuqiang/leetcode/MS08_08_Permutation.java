package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//排列
public class MS08_08_Permutation {
    public String[] permutation(String S) {
        List<String> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        char[] path = new char[chars.length];
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        backtrack(result,chars,path,0,used);
        return result.toArray(new String[result.size()]);
    }

    public void backtrack(List<String> result,char[] chars,char[] path,int depth,boolean[] used){
        if(depth == chars.length){
            result.add(String.valueOf(path));
            return;
        }
        for(int i = 0;i<chars.length;i++){
            if(used[i]) continue;
            if(i>0 && chars[i] == chars[i-1] && !used[i-1]) continue;
            used[i] = true;
            path[depth] = chars[i];
            backtrack(result,chars,path,depth+1,used);
            path[depth] = '\0';
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        MS08_08_Permutation ms08 = new MS08_08_Permutation();
        String[] strs = ms08.permutation("qqe");
        for(String str : strs){
            System.out.println(str);
        }
    }
}
