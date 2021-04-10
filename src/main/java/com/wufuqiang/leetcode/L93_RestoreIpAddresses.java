package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * 回溯算法
 * 回溯算法解题规范
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 */
public class L93_RestoreIpAddresses {
    public static void main(String[] args) {
        L93_RestoreIpAddresses l93 = new L93_RestoreIpAddresses();
        String str = "255255255255";
        str = "25525511035";
        List<String> results = l93.restoreIpAddresses(str);
        for(String result:results){
            System.out.println(result);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String[] path = new String[4];
        backtrack(result,path,0,-1,s);
        return result;
    }

    /**
     *
     * @param res 最终的结果集
     * @param path 每一条路径
     * @param pathIndex
     * @param endIndex
     * @param s
     */
    public void backtrack(List<String> res,String[] path,int pathIndex,int endIndex,String s){
        //判断是否已经处理完s中的所有字符
        if(endIndex==s.length()-1 && pathIndex == 4){
            res.add(String.join(".",path));
            return;
        }
        //处理出4个字段，但s还没有处理完，舍弃
        else if(pathIndex == 4) return;

        //选择列表
        //每一步选择最多3个数
        for(int i = endIndex+1;i<s.length() && i<= endIndex+3;i++){
            //舍弃以0开关的
            if(isBeginZero(s,endIndex+1,i)) break;
            int value = str2Int(s,endIndex+1,i) ;
            if(value > 255) continue;
            path[pathIndex] = String.valueOf(value);
            backtrack(res,path,pathIndex+1,i,s);
        }
    }

    /**
     * 判断是否以0开头，如果是单个0是可以的
     * @param s
     * @param beginIndex 包含的第一个字符
     * @param endIndex 包含的最后一个字符
     * @return
     */
    public boolean isBeginZero(String s, int beginIndex,int endIndex){
        if((endIndex-beginIndex+1) > 1 && s.charAt(beginIndex) == '0') return true;
        return false;
    }

    public int str2Int(String str,int beginIndex,int endIndex){
        int sum = 0;
        for(int i = beginIndex;i<=endIndex;i++){
            sum = sum*10+ str.charAt(i)-'0';
        }
        return sum;
    }
}

class Solution {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {   //已经有4段IP地址了
            if (segStart == s.length()) { //遍历完字符串了
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
