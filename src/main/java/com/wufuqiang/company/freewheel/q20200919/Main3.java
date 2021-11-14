package com.wufuqiang.company.freewheel.q20200919;

import java.util.*;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		


		sc.close();
	}
	public ArrayList<ArrayList<Integer>> hashJoin (ArrayList<Integer> setA, ArrayList<Integer> setB) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		V[] vs = new V[setA.size()+setB.size()];
		for(int i = 0;i<setA.size();i++){
			vs[i] = new V(setA.get(i),i,'A');
		}
		for(int i = 0 ;i<setB.size();i++){
			vs[setA.size()+i] = new V(setB.get(i),i,'B');
		}
		Arrays.sort(vs, new Comparator<V>() {
			@Override
			public int compare(V o1, V o2) {
				if(o1.value>o2.value){
					return 1;
				}else if(o1.value<o2.value){
					return -1;
				}else{
					if(o1.source > o2.source){
						return 1;
					}else if(o1.source < o2.source){
						return -1;
					}else{
						return 0;
					}
				}
			}
		});
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		int tmp = vs[0].value;;
		if(vs[0].source == 'A'){
			a.add(vs[0].position);
		}else{
			b.add(vs[0].position);
		}
		for(int i = 1;i<vs.length;i++){
			if(tmp == vs[i].value){
				if(vs[i].source=='A'){
					a.add(vs[i].position);
				}else{
					b.add(vs[i].position);
				}
			}else{
				for(int k : a){

					for(int z : b){
						ArrayList<Integer> integers = new ArrayList<>();
						integers.add(k);
						integers.add(z);
						res.add(integers);
					}
				}

				a.clear();
				b.clear();
				tmp = vs[i].value;
				if(vs[i].source=='A'){
					a.add(vs[i].position);
				}else{
					b.add(vs[i].position);
				}
			}
		}
		for(int k : a){

			for(int z : b){
				ArrayList<Integer> integers = new ArrayList<>();
				integers.add(k);
				integers.add(z);
				res.add(integers);
			}
		}
		return res;
	}
}

class V{
	public int value;
	public int position;
	public char source;

	public V(int value, int position, char source) {
		this.value = value;
		this.position = position;
		this.source = source;
	}
}
