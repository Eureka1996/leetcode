package com.wufuqiang.leetcode;

public class L1248_NumberOfSubarrays {

	public int numberOfSubarrays(int[] nums, int k) {
		int result = 0;
		int[] odd = new int[nums.length+2];
		int endIndex = 1;

		for(int i = 0;i<nums.length;i++){
			if(nums[i] % 2 == 1){
				odd[endIndex] = i;
				endIndex+=1;
			}
		}
		odd[0] = -1;
		odd[endIndex] = nums.length;
		if(endIndex < k) return result;
		for(int i = 1;i< endIndex-k+1;i++){
			result+=((odd[i]-odd[i-1])*(odd[i+k]-odd[i+k-1]));
		}
		return result;
	}

	public static void main(String[] args) {
		L1248_NumberOfSubarrays l1248 = new L1248_NumberOfSubarrays();
		int res = l1248.numberOfSubarrays(new int[]{1,1,2,1,1}, 3);
		System.out.println(res);
	}
}
