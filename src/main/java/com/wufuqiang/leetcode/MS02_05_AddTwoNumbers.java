package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;
//链表求和
public class MS02_05_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		ListNode first = l1;
		ListNode second = l2;
		ListNode res = new ListNode(0);
		ListNode tmp = res;
		while(first != null && second != null){
			int value = first.val+second.val + carry;
			carry = value/10;
			first.val = value%10;
			tmp.next = first;
			tmp = tmp.next;
			first = first.next;
			second = second.next;
		}
		while(first != null){
			int value = first.val+carry;
			carry = value/10;
			first.val = value%10;
			tmp.next = first;
			tmp = tmp.next;
            first = first.next;
		}
		while(second != null){
			int value = second.val+carry;
			carry = value/10;
			second.val = value%10;
			tmp.next = second;
			tmp = tmp.next;
			second = second.next;
		}
		if(carry>0){
			ListNode last = new ListNode(carry);
			tmp.next = last;
		}

		return res.next;
	}
}
