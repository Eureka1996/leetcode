package com.wufuqiang.company.meituan.q20200913;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *
 *
 * 测试用例
8 2 5
5 5 5 4 5 5 5 5

8 3 5
5 5 5 4 5 5 5 5


8 3 5
4 5 5 4 5 5 4 5

8 3 5
4 5 5 5 5 5 4 5
*/
public class Main2 {

	//记录要卖的个数
	private static int m ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		int[] grad = new int[n];

		//记录不能选的区间
		List<int[]> region = new ArrayList<>();
		//记录不能选的个数
		int canCount = 0;
		for(int i = 0;i<n;i++){
			grad[i] = sc.nextInt();
			if(grad[i] < k){
				int start = i-m+1;
				//向前找start时有可能越界
				if(start < 0) start = 0;

				int end = Math.min(i,n-m);
				if(region.size() == 0){
					region.add(new int[]{start,i});
					canCount = end-start+1;
				}else{
					int[] pre = region.get(region.size() - 1);
					if(pre[1]>=start){
						canCount += (end-pre[1]);
						pre[1] = i;
					}else{
						region.add(new int[]{start,i});
						canCount += (end-start+1);
					}
				}
			}
		}

		System.out.println(grad.length-m+1-canCount);
		sc.close();
	}
}
