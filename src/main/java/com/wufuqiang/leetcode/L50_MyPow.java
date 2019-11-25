package com.wufuqiang.leetcode;

public class L50_MyPow {
    public double fastPow(double x , long n){
        if(n == 0){
            return 1.0;
        }
        double half = fastPow(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        double result = fastPow(x, N);
        return result;
    }
}
