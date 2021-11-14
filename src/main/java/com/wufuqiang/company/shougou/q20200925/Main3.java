package com.wufuqiang.company.shougou.q20200925;

import java.util.*;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main3 m = new Main3();
		Interval[] conn = new Interval[]{
				new Interval(0,1),
				new Interval(2,-1),
				new Interval(1,2),
				new Interval(1,-1)
		};
		Interval trim = m.trim(2, 3, conn);
		System.out.println(trim.start+","+trim.end);

		sc.close();
	}

	public Interval trim (int N, int M, Interval[] conn) {
		// write code here
		Map<Integer, List<Integer>> map = new HashMap<>();
		boolean[] used = new boolean[N+1];
		int world = 0;
		int count = 0;
		for(Interval v : conn){
			List<Integer> orDefault = map.getOrDefault(v.start, new ArrayList<>());
			orDefault.add(v.end);
			map.put(v.start,orDefault);
		}

		LinkedList<int[]> queue = new LinkedList<>();
		List<Integer> nextWorld = map.get((Integer)0);
		used[0] = true;
		if(nextWorld == null){
			return new Interval(0,0);
		}else{
			for(int i : nextWorld){
				queue.offerLast(new int[]{i,i,1});
			}
		}
		while(!queue.isEmpty()){
			int[] ints = queue.pollFirst();
			nextWorld = map.get(ints[0]);
			used[ints[0]] = true;
			if(nextWorld != null){
				boolean flag = true;
				for(int i : nextWorld){
					if(i == -1){
						count += ints[1];
						if(flag){
							world+= ints[2];
							flag = false;
						}

					}else if(!used[i]){
						queue.offerLast(new int[]{i,ints[1]+i,ints[2]+1});
					}
				}
			}

		}
		return new Interval(Math.min(world,N),count);
	}



}

class Interval{
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}