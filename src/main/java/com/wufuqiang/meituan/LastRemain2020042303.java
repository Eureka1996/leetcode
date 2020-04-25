package com.wufuqiang.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//轮流出局 约瑟夫环
/*
现在有n名选手进行轮流报数，选手按顺序编号为1~n，另外我们会给出一个系列A游戏会进行n轮，每轮会出局一名选手
第i轮淘汰的选手最后的排名是n-i+1，每轮游戏都是从第一个选手开始报数。
 */
public class LastRemain2020042303 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[n];
		for(int i = 0 ; i < n ;i++){
			A[i] = scanner.nextInt();
		}
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		int len = 1;
		for(int i = A.length-2;i>=0;i--){
			len +=1;
			int pos = A[i] % len;
			result.add(pos,len);
		}

		for(int r : result){
			System.out.println(r);
		}

	}

}
