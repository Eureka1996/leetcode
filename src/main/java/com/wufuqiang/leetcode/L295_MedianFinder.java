package com.wufuqiang.leetcode;

import java.util.PriorityQueue;

public class L295_MedianFinder {
}

//数据流中的中位数
class MedianFinder {
	private int count = 0;
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;

	/** initialize your data structure here. */
	public MedianFinder() {
		count = 0;
		maxHeap = new PriorityQueue<>((x,y)-> y - x);
		minHeap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		count+=1;
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if((count&1)==1){
			maxHeap.offer(minHeap.poll());
		}

	}

	public double findMedian() {
		if((count&1) == 0){
			return (maxHeap.peek()+minHeap.peek())*0.5;
		}else{
			return maxHeap.peek();
		}
	}
}
