package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-12 09:17
 */
public class L1310_XorQueries {
    public static void main(String[] args) {

    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int tmp[] = new int[arr.length];
        int result[] = new int[queries.length];
        tmp[0] = arr[0];
        for(int i = 1;i<arr.length;i++ ){
            tmp[i] = tmp[i-1]^arr[i];
        }
        for(int i = 0;i<queries.length;i++){
            if(queries[i][0] == 0){
                result[i] = tmp[queries[i][1]];
            }else{
                result[i] = tmp[queries[i][0]-1]^tmp[queries[i][1]];
            }
        }
        return result;
    }
}
