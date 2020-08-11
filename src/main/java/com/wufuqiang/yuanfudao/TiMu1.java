package com.wufuqiang.yuanfudao;

import java.util.*;

/**
 * 猿辅导，抽奖，最大值
 */
public class TiMu1 {
	private static int maxScore = Integer.MIN_VALUE;
	private static int[] first ;
	private static int[] last ;
	private static Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int score = 0;
		int line = 0;
		for(int i = 2;i<=N+1 ;i++){
			score = scan.nextInt();
			line = scan.nextInt();
			List<int[]> orDefault = map.getOrDefault(line, new ArrayList<int[]>());
			orDefault.add(new int[]{score,line,i});
			map.put(line,orDefault);
		}

		scan.close();
		first = map.get(0).get(0);
		solution(first);
		System.out.println(maxScore);

	}

	public static void solution(int[] first){
		List<int[]> ints = map.get(first[2]);
		int sum = first[0];
		if(ints == null) return;
		for(int[] i:ints){
			solution(i);
			if(i[0]>0){
				sum=sum+i[0];
			}
		}
		first[0] = sum;
		if(maxScore<sum) maxScore=sum;
	}
}

