package com.wufuqiang.huawei.q20201125;

import java.util.*;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String[]> early = new HashSet<>();
		int[] et = null;
		Set<String[]> lastest = new HashSet<>();
		int[] lt = null;
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			if(line.equals("") || line == null){
				break;
			}
			String[] infos = line.split(" ");
			int[] t = turn(infos[1]);

			if(et == null){
				et = t;
				lt = t;
				early.add(new String[]{infos[0],infos[1]});
				lastest.add(new String[]{infos[0],infos[1]});
			}else{
				int i = whoLast(et, t);
				if(i == 2){
					et = t;
					early.clear();
					early.add(new String[]{infos[0],infos[1]});
				}else if(i == 0){
					early.add(new String[]{infos[0],infos[1]});
				}
				int i1 = whoLast(lt, t);
				if(i1 == 1){
					lt = t;
					lastest.clear();
					lastest.add(new String[]{infos[0],infos[1]});
				}else if(i1 == 0){
					lastest.add(new String[]{infos[0],infos[1]});
				}
			}

		}
		List<String[]> e = new ArrayList<>();
		early.forEach((i)-> e.add(i));
		Collections.sort(e, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].substring(1).compareTo(o2[0].substring(1));
			}
		});
//		early.forEach(System.out::println);
		for (String[] strings : e) {
			System.out.print(strings[0]+" ");
		}
		System.out.println();
		List<String[]> l = new ArrayList<>();
		lastest.forEach((i)-> l.add(i));
		Collections.sort(l, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].substring(1).compareTo(o2[0].substring(1));
			}
		});
		for (String[] strings : l) {
			System.out.print(strings[0]+" ");
		}
		sc.close();
	}

	public static int whoLast(int[] t1,int[] t2){
		boolean t1today = isToday(t1);
		boolean t2today = isToday(t2);

		int early = 0;
		if(t1[0] < t2[0]){
			early = 1;
		}else if(t1[0] > t2[0]){
			early = 2;
		}else{
			if(t1[1] < t2[1]){
				early = 1;
			}else if(t1[1] > t2[1]){
				early = 2;
			}else{
				if(t1[2] < t2[2]){
					early = 1;
				}else if(t1[2] > t2[2]){
					early = 2;
				}else{
					early = 0;
				}
			}
		}

		if(t1today && t2today){
			return early;
		}else if(t1today == false && t2today == false){
			return early;
		}else{
			return early == 0?0:early==1?2:1;
		}
	}

	public static boolean isToday(int[] t){
		boolean flag = true;
		if(t[0] < 5){
			return false;
		}
		return flag;
	}

	public static int[] turn(String t){
		String ap = t.substring(t.length()-2);
		String[] time = t.substring(0,t.length()-2).split(":");
		int[] res = new int[3];
		res[0] = Integer.parseInt(time[0]);
		res[1] = Integer.parseInt(time[1]);
		res[2] = Integer.parseInt(time[2]);
		if("PM".equals(ap)){
			res[0] = res[0]+12;
		}
		return res;
	}
}
