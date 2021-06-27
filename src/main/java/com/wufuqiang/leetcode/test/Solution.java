package com.wufuqiang.leetcode.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {



	public static void main(String[] args) {
		System.out.println("wufuqiang");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] mValue = new int[m];
		for(int i = 0 ; i < m ; i++){
			mValue[i] = scan.nextInt();
		}

		System.out.println(String.format("n=%d,m=%d",n,m));



//		Map<Integer,Integer> numToCountMap = getNumToCountMap();

	}

	public static Map<Integer,Integer> getNumToCountMap(){
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1,2);
		map.put(2,5);
		map.put(3,5);
		map.put(4,4);
		map.put(5,5);
		map.put(6,6);
		map.put(7,3);
		map.put(8,7);
		map.put(9,6);
		return map;
	}


}
