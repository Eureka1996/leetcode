package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 **/
public class L682_CalPoints {
    public int calPoints(String[] ops) {
        int sum = 0;
        int[] score = new int[ops.length];
        int validRound = -1;
        for(String o : ops){
            if(o.equals("+")){
                score[validRound+1] = score[validRound]+score[validRound-1];
                validRound+=1;
                sum+=score[validRound];
            }else if(o.equals("D")){
                score[validRound+1] = 2*score[validRound];
                validRound+=1;
                sum+=score[validRound];
            }else if(o.equals("C")){
                sum-=score[validRound];
                validRound-=1;
            }else{
                score[validRound+1] = Integer.parseInt(o);
                validRound+=1;
                sum+=score[validRound];
            }
        }
        return sum;
    }
}
