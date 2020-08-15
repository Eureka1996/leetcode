package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

public class L2_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);

		int carry = 0;
		int sum = 0;
		ListNode cur = result;
		while(l1 != null && l2 != null){
			sum = l1.val+l2.val+carry;
			carry = sum / 10;
			l1.val = sum % 10;
			cur.next = l1;
			cur = l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			sum = l1.val + carry;
			carry = sum / 10;
			l1.val = sum %10;
			cur.next = l1;
			cur = l1;
			l1 = l1.next;
		}

		while(l2 != null){
			sum = l2.val+carry;
			carry = sum /10;
			l2.val = sum %10;
			cur.next = l2;
			cur = l2;
			l2 = l2.next;
		}
		if(carry != 0){
			cur.next = new ListNode(carry);
		}

		return result.next;
	}
}
