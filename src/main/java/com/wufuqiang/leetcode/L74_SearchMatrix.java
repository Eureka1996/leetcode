package com.wufuqiang.leetcode;
//搜索二维矩阵
public class L74_SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) return false;
		int row = searchRow(matrix,0,matrix.length-1,target);
		if(row == -1) return false;

		return searchColumn(matrix[row],0,matrix[row].length-1,target);
	}

	public int searchRow(int[][] matrix,int low,int high,int target){
		if(low > high) return -1;
		if(low == high) return low;

		int mid = (low+high)/2+1;
		if(matrix[mid][0] > target){
			return searchRow(matrix,low,mid-1,target);
		}else if(matrix[mid][0] < target){
			return searchRow(matrix,mid,high,target);
		}else{
			return mid;
		}

	}

	public boolean searchColumn(int[] arr,int low,int high,int target){
		if(low > high) return false;
		int mid = (low+high)/2;
		if(arr[mid] == target){
			return true;
		}else if(arr[mid] > target){
			return searchColumn(arr,low,mid-1,target);
		}else{
			return searchColumn(arr,mid+1,high,target);
		}
	}
}
