package com.wufuqiang.leetcode;
//开方
public class L69_MySqrt {
	public int mySqrt(int x) {
		if(x<=1) return x;
		double x0 = x;
		while(true){
			double xi = 0.5*(x0+x/x0);
			if(Math.abs(x0-xi)<1e-7){
				break;
			}
			x0 = xi;
		}
		return (int)x0;
	}
}
