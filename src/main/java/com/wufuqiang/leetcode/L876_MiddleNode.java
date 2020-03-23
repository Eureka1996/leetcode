package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

public class L876_MiddleNode {
	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode high = head;

		while(high.next != null){

			slow = slow.next;
			high = high.next;
			if(high.next != null){
				high = high.next;
			}
		}
		return slow;
	}
}
