package com.wufuqiang.leetcode;
//最大连续子数组
public class L53_MaxSubArray {
	public int maxSubArray(int[] nums) {
		int result = 0;
		result = sumSubArray(nums,0,nums.length-1);
		return result;
	}

	public int sumSubArray(int[] nums,int left ,int right){
		if(left>right) return Integer.MIN_VALUE;
		if(left==right) return nums[left];
		int mid = (left+right)/2;
		int leftMax = sumSubArray(nums,left,mid);
		int rightMax = sumSubArray(nums,mid+1,right);
		int crossMax = crossSumMax(nums,left,mid,right);
		return Math.max(Math.max(leftMax,rightMax),crossMax);
	}

	private int crossSumMax(int[] nums, int left, int mid, int right) {
		if(right-left<1) return Integer.MIN_VALUE;
        int sum = nums[mid]+nums[mid+1];
        int tmp = sum;
        for(int i = mid-1;i>=left;i--){
        	tmp+=nums[i];
        	if(tmp>sum){
        		sum = tmp;
	        }
        }
        tmp = sum;
        for(int i = mid+2;i<=right;i++){
        	tmp+=nums[i];
        	if(tmp > sum) sum = tmp;
        }
		return sum;
	}

}
