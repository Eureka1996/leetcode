package com.wufuqiang.leetcode;

import java.util.*;

public class L365_CanMeasureWater {
	public boolean canMeasureWater2(int x, int y, int z) {
		if(x+y < z){
			return false;
		}
		if(x == 0 || y == 0){
			return z == 0 || x+y == z;
		}
		return z % getGCD(x,y) == 0;
	}

	//计算最大公约数
	public int getGCD(int a, int b) {
		if (a < 0 || b < 0) {
			return -1; // 数学上不考虑负数的约数
		}
		if (b == 0) {
			return a;
		}
		while (a % b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}

	public boolean canMeasureWater(int x, int y, int z) {
		LinkedList<List<Integer>> stack = new LinkedList<>();
		stack.offerFirst(Arrays.<Integer>asList(0,0));
		Set<List<Integer>> set = new HashSet<>();
		while(! stack.isEmpty()){
			List<Integer> remain = stack.pollFirst();
			if(remain.get(0) == z || remain.get(1) == z || (remain.get(0) + remain.get(1)) == z){
				return true;
			}
			if( set.contains(remain)){
				continue;
			}
			set.add(remain);
			stack.offerFirst(Arrays.asList(x,remain.get(1)));
			stack.offerFirst(Arrays.asList(remain.get(0),y));
			stack.offerFirst(Arrays.asList(0,remain.get(1)));
			stack.offerFirst(Arrays.asList(remain.get(0),0));
			stack.offerFirst(Arrays.asList(remain.get(0) - Math.min(remain.get(0),y-remain.get(1)),
					remain.get(1)+Math.min(remain.get(0),y-remain.get(1))));

			stack.offerFirst(Arrays.asList(remain.get(0) + Math.min(remain.get(1),x-remain.get(0)),
					remain.get(1)-Math.min(remain.get(1),x-remain.get(0))));

		}

		return false;
	}


}
