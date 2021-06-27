package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.thrid.Node;

import java.util.HashMap;
import java.util.Map;

public class MS35_CopyRandomList {
	Map<Node,Node> visited = new HashMap<>();
	public Node copyRandomList(Node head) {
		if(head == null) return null;
		if(this.visited.containsKey(head)) return this.visited.get(head);
		Node node = new Node(head.val);
		this.visited.put(head,node);
		node.next = copyRandomList(head.next);
		node.random = copyRandomList(head.random);
		return node;
	}
}
