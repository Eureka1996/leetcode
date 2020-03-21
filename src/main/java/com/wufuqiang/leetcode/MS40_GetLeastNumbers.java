package com.wufuqiang.leetcode;

public class MS40_GetLeastNumbers {
	public static void main(String[] args) {
		MS40_GetLeastNumbers ms = new MS40_GetLeastNumbers();
//		ms.getLeastNumbers(new int[]{0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75},75);
		ms.getLeastNumbers(new int[]{3,2,1
		},2);
	}
	public int[] getLeastNumbers(int[] arr, int k) {
		if(arr.length <= k){
			return arr;
		}
		int low = 0;
		int hight = arr.length-1;
		int[] result = new int[k];
		int tmpK = k;
		int endIndex = 0;
		while(low<=hight){
			int[] minAndEqualCount = partition(arr,low,hight);
			System.out.println(low+","+hight+","+k+","+minAndEqualCount[0]+","+minAndEqualCount[1]);
			if(minAndEqualCount[0]-low>k){
				hight = minAndEqualCount[0]-1;
			}else if(minAndEqualCount[0] - low == k){
				endIndex = minAndEqualCount[0] -1;
				break;
			} else{
				if (minAndEqualCount[0] - low + 1 + minAndEqualCount[1] >= k ){
					endIndex = minAndEqualCount[0];
					break;
				}else{

//					System.out.println("k="+k+","+minAndEqualCount[0]+","+low);
					k=k-(minAndEqualCount[0]-low+1);
					low = minAndEqualCount[0]+1;
//					System.out.println("k====="+k);
				}
			}
		}
		for(int i:arr){
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println(endIndex);
		int i = 0 ;
		for(i = 0;i<endIndex;i++){
			result[i] = arr[i];
		}
		for(;i<tmpK;i++){
			result[i] = arr[endIndex];
		}
		for(int j : result ){
			System.out.println("result:"+j);
		}

		return result;
	}

	public int[] partition(int[] arr,int low ,int hight){
		int i = low-1;
		int x = arr[hight];
		int equalCount = 0;
		for(int j = low ; j < hight;j++){
			if(arr[j] < x){
				i+=1;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;

			}else if(arr[j] == x){
				equalCount+=1;
			}
		}
		i+=1;
		int temp = arr[i];
		arr[i] = arr[hight];
		arr[hight] = temp;
		return new int[]{i,equalCount};
	}
}
