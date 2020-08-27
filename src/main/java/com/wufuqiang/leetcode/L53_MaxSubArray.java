package com.wufuqiang.leetcode;
//最大连续子数组
public class L53_MaxSubArray {
	/**
	 * 分治的方法
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int result = 0;
		result = sumSubArray(nums,0,nums.length-1);
		return result;
	}



	/**
	 *
	 * @param nums 给定的数组
	 * @param left 给定的最左边的数组索引，包含
	 * @param right 给定的最右边的数组索引，包含
	 * @return
	 */
	public int sumSubArray(int[] nums,int left ,int right){

		if(left>right) return Integer.MIN_VALUE;
		if(left==right) return nums[left];
		int mid = (left+right)/2;
		int leftMax = sumSubArray(nums,left,mid);
		int rightMax = sumSubArray(nums,mid+1,right);
		int crossMax = crossSumMax(nums,left,mid,right);
		return Math.max(Math.max(leftMax,rightMax),crossMax);
	}

	/**
	 * 包含中间两个节点的最大值
	 * @param nums
	 * @param left
	 * @param mid
	 * @param right
	 * @return
	 */
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

	/**
	 * 动态规划的方法
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
		int result = nums[0];
		for(int i =1;i<nums.length;i++){
			nums[i] += Math.max(nums[i-1],0);
			result = Math.max(result,nums[i]);
		}
		return result;
	}

}
