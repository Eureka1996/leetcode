package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class L380_RandomizedSet {
}
//常数时间插入、删除和获取随机元素
class RandomizedSet {

	private HashMap<Integer,Integer> value2Index;
	private ArrayList<Integer> value ;
	Random random = new Random();

	/** Initialize your data structure here. */
	public RandomizedSet() {
		value2Index  = new HashMap<>();
		value = new ArrayList<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(value2Index.containsKey(val)) return false;
		value2Index.put(val,value.size());
		value.add(val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		//删除HashMap中的值
		Integer index = value2Index.remove(val);
		//如果没有包含val值，返回false
		if(index == null) return false;
		//ArrayList长度
		int count = value.size()-1;
		if(count == index){
			value.remove(count);
		}else{
			int lastValue = value.remove(count);
			value.set(index,lastValue);
			value2Index.put(lastValue,index);
		}
		return true;

	}

	/** Get a random element from the set. */
	public int getRandom() {
		return value.get(random.nextInt(value.size()));
	}
}