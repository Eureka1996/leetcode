package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;
//分割链表
public class MS02_04_Partition {
	public ListNode partition(ListNode head, int x) {
		ListNode left = new ListNode(0);
		ListNode right = new ListNode(1);
		ListNode tmp = head;
		ListNode leftFirstNode = null;
		while(tmp != null){
			ListNode next = tmp.next;
			if(tmp.val < x){
				if(left.next == null) leftFirstNode = tmp;
				tmp.next = left.next;
				left.next = tmp;
			}else{
				tmp.next = right.next;
				right.next = tmp;

			}
			tmp = next;
		}
		if(leftFirstNode != null){
			leftFirstNode.next = right.next;
			return left.next;
		}else{
			return right.next;
		}
	}
}
