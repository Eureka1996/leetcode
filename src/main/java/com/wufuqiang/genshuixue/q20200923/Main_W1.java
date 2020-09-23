package com.wufuqiang.genshuixue.q20200923;

import java.util.*;

public class Main_W1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		sc.close();
	}


	public static List<List<String>> mergeAccount(List<List<String>> count){
		Map<String,String> e2n = new HashMap<>();
		for(int j=0;j<count.size();j++){
			List<String> l = count.get(j);
			boolean flag = false;
			String name = l.get(0)+","+j;
			for(int i = 1;i<l.size();i++){
				if(!flag){
					String oldName = e2n.get(l.get(i));
					if(oldName != null){
						name = oldName;
						flag = true;
					}else{
						e2n.put(l.get(i),name);
					}
				}else{
					e2n.put(l.get(i),name);
				}
			}
		}

		Map<String,List<String>> n2e = new HashMap<>();
		for(Map.Entry<String,String> entry:e2n.entrySet()){
			String email = entry.getKey();
			String name = entry.getValue();
			List<String> orDefault = n2e.getOrDefault(name, new ArrayList<>());
			orDefault.add(email);
			n2e.put(name,orDefault);
		}

		List<List<String>> res = new ArrayList<>();
		for(Map.Entry<String,List<String>> entry:n2e.entrySet()){
			String key = entry.getKey();
			List<String> value = entry.getValue();
			Collections.sort(value);
			value.add(0,key.split(",")[0]);
		}

		return res;
	}
}
