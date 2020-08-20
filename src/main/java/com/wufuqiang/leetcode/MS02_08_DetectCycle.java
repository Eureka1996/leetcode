package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

/**
 * 检测环路
 * 确定环路的开始节点
 */
public class MS02_08_DetectCycle {
	public ListNode detectCycle(ListNode head) {
		//快慢指针的开始都是头节点
		ListNode slow = head;
		ListNode fast = head;
		//标记是否有环
		boolean haveCycle = true;
		//快慢指针向前移动
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
			}else{
				//fast为空，表示有环
				haveCycle = false;
				break;
			}
			//有环时，快慢指针会相遇
			if(fast == slow) break;
		}
		//fast为空，表示有环
		if(fast == null) haveCycle = false;
		if(!haveCycle) return null;
		else{
			//快指针指向头部
			fast = head;
			while(fast != slow){
				fast = fast.next;
				slow = slow.next;
			}
			return fast;
		}
	}
}
