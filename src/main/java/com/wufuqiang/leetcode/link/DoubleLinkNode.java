package com.wufuqiang.leetcode.link;

/**
 * 双向链表的节点
 */
public class DoubleLinkNode{
	//在LRU中，需要记录key，方便删除链表时可以删除对应map中的内容
	public int key;
	public int value;
	public DoubleLinkNode prev;
	public DoubleLinkNode next;

	public DoubleLinkNode(){}

	public DoubleLinkNode(int key,int value){
		this.key = key;
		this.value = value;
	}
}
