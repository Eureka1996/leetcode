package com.wufuqiang.leetcode;

public class L215_FindKthLargest {
	public static void main(String[] args) {
		L215_FindKthLargest l215 = new L215_FindKthLargest();
		int result = l215.findKthLargest(new int[]{3,2,1,5,6,6,4},2);
		System.out.println(result);
	}
	public int findKthLargest(int[] nums, int k) {
		int low = 0;
		int high = nums.length-1;
		int tmpK = k;
		int index = 0;
		while(low<=high){
			int[] indexAndCount = partition(nums,low,high);
			System.out.println("low="+low+",mid="+indexAndCount[0]+",high"+high+",tmpK"+tmpK+","+indexAndCount[1]);
			if(indexAndCount[0] - low>=tmpK){
				high = indexAndCount[0]-1;
			}else if(indexAndCount[0] - low + 1 + indexAndCount[1] >= tmpK){
				index = indexAndCount[0];
				break;
			}else {
				tmpK = tmpK - (indexAndCount[0] - low + 1);
				low = indexAndCount[0]+1;
			}
		}


		return nums[index];
	}

	public int[] partition(int[] nums,int low,int high){
		int i = low -1;
		int x = nums[high];
		int count = 0;
		for(int j = low ;j<high;j++){
			if(nums[j]>x){
				i = i+1;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;

			}else if(nums[j] == x){
				count+=1;
			}
		}
		i=i+1;
		int tmp = nums[i];
		nums[i] = nums[high];
		nums[high] = tmp;
		return new int[]{i,count};
	}
}
