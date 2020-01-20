package com.wufuqiang.leetcode;

public class L1093_SampleStats {
    public double[] sampleStats(int[] count) {
        double[] result = new double[5];
        int countSum = 0;
        long sum = 0;
        int maxCount = 0;
        int min = 0;
        int max = 0;
        int modalNum = 0;
        boolean isMin = true;
        for(int i = 0 ;i<count.length;i++){
            if(count[i] != 0){
                max = i;
                if(isMin){
                    min = i;
                    isMin = false;
                }
                sum += (i*count[i]);
                countSum += count[i];
                if(maxCount < count[i]){
                    maxCount = count[i];
                    modalNum = i;
                }
            }
        }
        result[0] = min;
        result[1] = max;
        result[2] = sum*1.0/countSum;
        result[4] = modalNum;
        if(countSum%2==1){
            int index = countSum/2+1;
            countSum = 0;
            for(int i = 0 ;i<count.length;i++){
                if(count[i] != 0){
                    countSum+=count[i];
                }
                if(index <= countSum ){
                    result[3] = i;
                    break;
                }
            }
        }else{
            int index1 = countSum/2;
            int index2 = index1 + 1;
            countSum = 0;
            int num1 = 0;
            int num2 = 0;
            boolean isGetedNum1 = false;
            for(int i = 0 ;i<count.length;i++){
                if(count[i] != 0){
                    countSum+=count[i];
                }
                if(index1 <= countSum && !isGetedNum1){
                    num1 = i;
                    isGetedNum1 = true;
                }
                if(index2<=countSum){
                    num2  = i;
                    break;
                }
            }
            result[3] = (num1+num2)*1.0/2;
        }
        return result;
    }
}
