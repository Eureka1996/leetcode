package com.wufuqiang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * 我们猜测会有以下三种可能。
 *
 * 最终会得到 1。
 * 最终会进入循环。
 * 值会越来越大，最后接近无穷大。通过归纳法，证明它是不会发生的
 */
public class L202_IsHappy {
	public boolean isHappy(int n) {
		while(n >= 10){
			int m = n,sum = 0;
			while(m != 0){
				int t = m % 10;
				sum += t * t;
				m /= 10;
			}
			n = sum;
		}
		return n == 1 || n == 7;
	}

	//获取一个数的各个位的平方和
	public int getSquareSum(int n){
		int tmp = 0 ;
		int sum = 0;
		while(n>0){
			tmp=n%10;
			n=n/10;
			sum+=(tmp*tmp);
		}
		return sum;
	}
	//通过hashset判断是否有循环
	public boolean isHappy2(int n){
		Set<Integer> set = new HashSet<>();
		while(n!=1 && !set.contains(n)){
			set.add(n);
			n=getSquareSum(n);
		}
		return n==1;
	}

	public static void main(String[] args) {
		L202_IsHappy l202 = new L202_IsHappy();
		boolean happy2 = l202.isHappy2(8);
		System.out.println(happy2);
	}
}
