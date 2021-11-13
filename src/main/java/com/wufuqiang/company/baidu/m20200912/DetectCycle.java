package com.wufuqiang.company.baidu.m20200912;

import com.wufuqiang.leetcode.link.LinkNode;

public class DetectCycle {
	public static void main(String[] args) {


	}

	public static LinkNode getMeetNode(LinkNode head){
		if(head == null) return head;
		LinkNode low = head;
		LinkNode fast = head;
		while(fast != null){
			low = low.next;
			fast = fast.next;
			if(fast == null){
				break;
			}else{
				fast = fast.next;
			}
			if(low == fast){
				break;
			}
		}
		return fast;
	}

	public static LinkNode getStartNode(LinkNode head){
		LinkNode meetNode = getMeetNode(head);
		if(meetNode == null) return null;
		while(head != meetNode){
			head = head.next;
			meetNode = meetNode.next;
		}
		return head;
	}

}
