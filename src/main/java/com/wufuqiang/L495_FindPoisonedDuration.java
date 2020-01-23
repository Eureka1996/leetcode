package com.wufuqiang;

/**
 * @ author wufuqiang
 **/
public class L495_FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < timeSeries.length ; i++){
            if(end <= timeSeries[i]){
                sum+=duration;
            }else if(end >= timeSeries[i]+duration){
                continue;
            }else{
                int remainTime = end-timeSeries[i];
                sum+=(duration-remainTime);
            }
            start = timeSeries[i];
            end = start + duration;
        }
        return sum;

    }
}
