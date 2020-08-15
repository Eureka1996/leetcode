package com.wufuqiang.leetcode.jianzhioffer;

import com.wufuqiang.leetcode.entries.ListNode;

public class O25_MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode tmp = null;
		ListNode cur = result;
		while(l1 != null && l2 != null){
			if (l1.val < l2.val){
				tmp = l1;
				l1 = l1.next;
			}else{
				tmp = l2;
				l2 = l2.next;
			}
			cur.next = tmp;
			cur = tmp;
		}
		if(l1 != null){
			cur.next = l1;
		}
		if(l2 != null){
			cur.next = l2;
		}

		return result.next;
	}
}
