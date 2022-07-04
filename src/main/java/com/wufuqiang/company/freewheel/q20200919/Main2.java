package com.wufuqiang.company.freewheel.q20200919;

import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		


		sc.close();
	}

	public ArrayList<ArrayList<Integer>> hashJoin (ArrayList<Integer> setA, ArrayList<Integer> setB) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Map<Integer, List<Integer>> smallTable = new HashMap<>();
		ArrayList<Integer> s = null;
		ArrayList<Integer> b = null;
		boolean flag = true;
		if(setA.size()<setB.size()){
			s = setA;
			b = setB;
		}else{
			s = setB;
			b = setA;
			flag = false;
		}
		for(int i = 0;i<s.size();i++){
			List<Integer> orDefault = smallTable.getOrDefault(s.get(i), new ArrayList<>());
			orDefault.add(i);
			smallTable.put(s.get(i),orDefault);
		}

		for(int i = 0;i<b.size();i++){
			List<Integer> orDefault = smallTable.get(b.get(i));
			if(orDefault!=null){
				if(flag){
					for(int p:orDefault){
						ArrayList<Integer> integers = new ArrayList<>();
						integers.add(p);
						integers.add(i);
						res.add(integers);
					}
				}else{
					for(int p:orDefault){
						ArrayList<Integer> integers = new ArrayList<>();
						integers.add(i);
						integers.add(p);
						res.add(integers);
					}
				}
			}

		}

		return res;
	}
}
