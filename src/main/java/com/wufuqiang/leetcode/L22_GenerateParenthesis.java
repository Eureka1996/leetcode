package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//括号生成
public class L22_GenerateParenthesis {
    public static void main(String[] args) {
        L22_GenerateParenthesis l22 = new L22_GenerateParenthesis();
        List<String> result = l22.generateParenthesis(10);
        for(String str : result){
            System.out.println(str);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        backtrack(result,sb,n,0,0);
        return result;
    }
    public void backtrack(List<String> res,StringBuffer sb,int n,int left,int right){
        if(right > left || left > n || right > n){
            return;
        }
        if(left == n && right == n){
            res.add(sb.toString());
            return;
        }
        sb.append('(');
        left+=1;
        backtrack(res,sb,n,left,right);
        left-=1;
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        right+=1;
        backtrack(res,sb,n,left,right);
        right-=1;
        sb.deleteCharAt(sb.length()-1);

    }

}
