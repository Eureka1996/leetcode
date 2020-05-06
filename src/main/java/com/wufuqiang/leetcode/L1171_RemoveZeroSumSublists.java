package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

import java.util.HashMap;
import java.util.Map;
//从链表中删去总和值为零的连续节点
public class L1171_RemoveZeroSumSublists {
	public ListNode removeZeroSumSublists(ListNode head) {
		ListNode tmp = new ListNode(0);
		tmp.next = head;

		Map<Integer,ListNode> sumMap = new HashMap<>();

		ListNode d = tmp;
		int sum = 0;
		while(d != null){
			sum+=d.val;
			sumMap.put(sum,d);
			d = d.next;
		}

		d = tmp;
		sum = 0;
		while(d!=null){
			sum+=d.val;
			d.next = sumMap.get(sum).next;
			d = d.next;
		}
		return tmp.next;
	}
}
