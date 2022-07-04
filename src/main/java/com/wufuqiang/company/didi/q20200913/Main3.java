package com.wufuqiang.company.didi.q20200913;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main3 {
	private static int n = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			if(n == 0) return;
			int m = in.nextInt();
			Vertex[] list = new Vertex[n+1];
			for(int i = 1;i<=n;i++){
				list[i] = new Vertex(i);
			}

			for(int i = 0;i<m;i++){
				int a = in.nextInt();
				int b = in.nextInt();
				int dist = in.nextInt();
				list[a].edge.add(new Edge(b,dist));
				list[b].edge.add(new Edge(a,dist));
			}
			int s = in.nextInt();
			int t = in.nextInt();
			String time = in.nextLine();
			boolean[] marked = new boolean[n+1];
			int[] dist = new int[n+1];
			for(int i = 1;i<=n;i++ ){
				dist[i] = -1;
				marked[i] = false;
			}
			dist[s] = 0;
			marked[s] = true;
			int p = s;
			for(int i = 1;i<=n;i++){
				for(int j = 0;j<list[p].edge.size();j++){
					int next = list[p].edge.get(j).next;
					int d =  list[p].edge.get(j).dist;
					if(marked[next] == true) continue;
					if(dist[next] == -1 || dist[next]>dist[p]+d || dist[next] == dist[p] +d){
						dist[next] = dist[p] +d;
					}
				}
				int min = Integer.MAX_VALUE;
				for(int j = 1;j<=n;j++) {
					if(marked[j]) continue;
					if(dist[j] == -1) continue;
					if(dist[j] < min){
						min = dist[j];
						p = j;
					}

				}
				marked[p] = true;
			}
			System.out.println(addDateMinut(time,dist[t]));
		in.close();
	}

	public static String addDateMinut(String day , int hour){
		SimpleDateFormat format = new SimpleDateFormat("M.d/H");
		Date date = null;

		try {
			date = format.parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(date == null){
			return "";
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR,hour);
		date = cal.getTime();
		return format.format(date);
	}
}

class Edge{
	int next;
	int dist;
	public Edge(int next, int dist) {
		this.next = next;
		this.dist = dist;
	}
}

class Vertex{
	int num;
	ArrayList<Edge> edge;

	public Vertex(int num) {
		this.num = num;
		this.edge = new ArrayList<>();
	}
}