package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并K个升序链表
 */
public class L23_MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		//优先队列，小的排在前面
		Queue<ListNode> pq = new PriorityQueue<>((v1,v2)->v1.val-v2.val);
		//将k个链表的第一个节点推到到优先队列中
		for(ListNode list:lists){
			if(list != null) pq.offer(list);
		}
		// 最终的链表，合并后链表，此变量不能变，用于最后方法的返回
		ListNode result = new ListNode(0);
		// 一直后移的节点
		ListNode tail = result;
		ListNode minNode = null;
		// 优先队列如果空了，则所有的链表已经遍历完成
		while (!pq.isEmpty()){
			//弹出优先队列中最小的那个节点
			minNode = pq.poll();
			// 进行合并
			tail.next = minNode;
			tail = tail.next;
			// 链表是否还有下一个节点
			minNode = minNode.next;
			//下一个节点如果不为空，则推入到优先队列中
			if(minNode != null){
				pq.offer(minNode);
			}
		}
		return result.next;
	}
}
