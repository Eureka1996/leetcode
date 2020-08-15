package com.wufuqiang.leetcode;

/**
 * 寻找旋转排序数组中的最小值
 */
public class L153_FindMin {

	public int searchRec(int[] nums,int low,int high){
		if(low>high){
			return Integer.MAX_VALUE;
		}
		if(low == high){
			return nums[low];
		}
		//获取中间的索引
		int mid = (low+high)/2;
		//若nums[low] <= nums[mid]，则左边是有序的，转折点在右边
		if(nums[low] <= nums[mid]){
			return Math.min(nums[low],searchRec(nums,mid+1,high));
		}else{
			//右边是有序的，转折点在左边
			return Math.min(nums[mid],searchRec(nums,low,mid-1));
		}
	}

	public int findMin(int[] nums) {
		return searchRec(nums,0,nums.length-1);
	}

	public static void main(String[] args) {
		L153_FindMin l153 = new L153_FindMin();
		System.out.println(l153.findMin(new int[]{4,5,6,7}));
	}
}
