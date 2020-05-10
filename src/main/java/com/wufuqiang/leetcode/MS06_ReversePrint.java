package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

import java.util.LinkedList;
//从尾到头打印链表
//倒序打印链表
public class MS06_ReversePrint {
	public int[] reversePrint(ListNode head) {
		LinkedList<Integer> stack = new LinkedList<>();
		ListNode headTmp = head;
		while(headTmp != null){
			stack.offerFirst(headTmp.val);
			headTmp = headTmp.next;
		}

		int[] result = new int[stack.size()];
		int size = stack.size();
		for(int i = 0;i<size;i++){
			result[i] = stack.pollFirst();
		}
		return result;

	}
}
