package com.wufuqiang.wangyi.game;

import java.util.*;

public class NSet {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0 ; i < t;i++){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			LinkedList<Integer> emptySet = new LinkedList<>();
			// index为数字，value为set的编号
			int[] n2set = new int[n+1];
			for(int z = 1;z<=n;z++){
				n2set[z] = z;
			}
			Map<Integer, Set<Integer>> set2n = new HashMap<Integer,Set<Integer>>();
			for(int z = 1;z<=n;z++){

				HashSet<Integer> set = new HashSet<>();
				set.add(z);
				set2n.put(z,set);
			}
			for(int j = 0;j<m;j++){
				int op = scanner.nextInt();
				int x = 0;
				int y = 0;

				if(op == 1){
					 x = scanner.nextInt();
					 y = scanner.nextInt();
					 if(n2set[x] != n2set[y]){
					 	emptySet.offerLast(n2set[y]);
					 	Set<Integer> xset = set2n.get(n2set[x]);
					 	Set<Integer> yset = set2n.get(n2set[y]);
					 	for(int yt : yset){
					 		n2set[yt] = n2set[x];
					 		xset.add(yt);
					 	}
					 	set2n.put(n2set[x],xset);

					 }

				}else if(op == 2){
					x = scanner.nextInt();
					Set<Integer> tmpSet = set2n.get(n2set[x]);
					if(tmpSet.size() != 1){
						tmpSet.remove(x);
						int newSetIndex = emptySet.pollFirst();
						Set<Integer> newSet = set2n.get(newSetIndex);
						newSet.add(x);
						n2set[x] = newSetIndex;
						set2n.put(newSetIndex,newSet);
					}

				}else if(op == 3){
					x = scanner.nextInt();
					int size = set2n.get(n2set[x]).size();
					System.out.println(size);
				}

			}
		}
		scanner.close();
	}
}
