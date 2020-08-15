package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉诺塔
 */
public class MS08_06_Hanota {

	public static void main(String[] args) {
		MS08_06_Hanota han = new MS08_06_Hanota();
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		List<Integer> C = new ArrayList<>();
		A.add(3);
		A.add(2);
		A.add(1);
		A.add(0);
		han.hanota(A,B,C);
		for(int i : A){
			System.out.println(i);
		}
		System.out.println("------------------");
		for(int i : B){
			System.out.println(i);
		}
		System.out.println("------------------");
		for(int i : C){
			System.out.println(i);
		}
		System.out.println("------------------");
	}

	public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
		hanoi(A.size(),A,B,C);
	}
	public void move(List<Integer> A,List<Integer> C){
		Integer remove = A.remove(A.size() - 1);
		C.add(remove);
	}

	public void hanoi(int n,List<Integer> A, List<Integer> B, List<Integer> C){
		if(n==1){
			move(A,C);
		}else{
			hanoi(n-1,A,C,B);
			move(A,C);
			hanoi(n-1,B,A,C);
		}
	}
}
