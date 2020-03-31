package com.wufuqiang.leetcode;

import java.util.Random;

public class L912_SortArray {
	private Random random = new Random();

	public static void main(String[] args) {
		L912_SortArray l912 = new L912_SortArray();
		int[] nums = new int[]{};
		l912.sortArray(nums);
		for(int i : nums){
			System.out.println(i);
		}
	}

	public int[] sortArray(int[] nums) {
		if(nums == null){
			return nums;
		}
		sort(nums,0,nums.length-1);
		return nums;
	}

	public void sort(int[] nums,int low,int high){
		if(low>=high){
			return;
		}
		int index = partition(nums,low,high);
		sort(nums,low,index-1);
		sort(nums,index+1,high);

	}

	public int partition(int[] nums,int low,int high){
		int i=low-1;
//		System.out.println(String.format("low:%d,high:%d",low,high));
		int index = random.nextInt(high) % (high-low+1) + low;
		int t = nums[index];
		nums[index] = nums[high];
		nums[high] = t;
 		int x = nums[high];
		for(int j = low ;j<high;j++){
			if(nums[j]<x){
				i=i+1;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		i=i+1;
		int tmp = nums[i];
		nums[i] = nums[high];
		nums[high] = tmp;

		return i;
	}
}
