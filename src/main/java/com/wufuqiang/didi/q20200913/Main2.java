package com.wufuqiang.didi.q20200913;

import java.util.*;

public class Main2 {
	private static int n = 0;
	private static int m = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		Map<Integer, List<Road>> roads = new HashMap<>();

		for(int i = 0;i<m;i++){
			Road r = new Road();
			r.start = sc.nextInt();
			r.end = sc.nextInt();
			r.time = sc.nextInt();

			List<Road> ends = roads.getOrDefault(r.start, new ArrayList<>());
			ends.add(r);
			roads.put(r.start,ends);
		}
		sc.nextLine();
		String[] strs = sc.nextLine().split(" ");

		int s = Integer.parseInt(strs[0]);
		int e = Integer.parseInt(strs[1]);
		String d = strs[3];

		List<Road> roads1 = roads.get(s);
		LinkedList<Road> queue = new LinkedList<>();
		for(Road rr : roads1){
//			rr.
			queue.offerLast(rr);
		}

		while(!queue.isEmpty()){

		}


		sc.close();
	}
}

class Road{
	public int start;
	public int end;
	public int time;
	public int spend = Integer.MAX_VALUE;
}
