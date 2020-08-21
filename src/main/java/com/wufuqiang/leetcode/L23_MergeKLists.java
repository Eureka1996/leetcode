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
		ListNode result = new ListNode(0);
		ListNode tail = result;
		ListNode minNode = null;
		while (!pq.isEmpty()){
			//弹出优先队列中最小的那个节点
			minNode = pq.poll();
			tail.next = minNode;
			tail = tail.next;
			minNode = minNode.next;
			//下一个节点如果不为空，则推入到优先队列中
			if(minNode != null){
				pq.offer(minNode);
			}
		}

		return result.next;
	}
}
