package com.wufuqiang.leetcode.lcs;

import java.util.Arrays;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-17 00:45
 */
public class Lcs02_HalfQuestions {
    public int halfQuestions(int[] questions) {
        //题目解读：就是按类型出现的次数排序，然后选N个，看看包括多少种类型
        int[] ints = new int[1001];//这个数组来存数字（也就是题目的类型）出现的次数啊
        for(int i=0;i<questions.length;i++){
            ints[questions[i]]++;//存了
        }
        Arrays.sort(ints);
        int count=0;//看看目前几个类型的总和够了没
        int i=1000;
        int n=questions.length/2;
        while(count<n){
            count+=ints[i--];
        }
        return 1000-i;
    }
}
