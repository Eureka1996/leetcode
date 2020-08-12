package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.link.DoubleLinkNode;

import java.util.HashMap;
import java.util.Map;

public class MS16_25_LRUCache {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // 返回  1
		cache.put(3, 3);    // 该操作会使得密钥 2 作废
		System.out.println(cache.get(2));       // 返回 -1 (未找到)
		cache.put(4, 4);    // 该操作会使得密钥 1 作废
		cache.get(1);       // 返回 -1 (未找到)
		cache.get(3);       // 返回  3
		cache.get(4);       // 返回  4
	}
}

/**
 * LRU
 */
class LRUCache {

	public int capacity ;
	public int size;
	public DoubleLinkNode head;
	public DoubleLinkNode tail;
	public Map<Integer, DoubleLinkNode> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.head = new DoubleLinkNode();
		this.tail = new DoubleLinkNode();
		this.head.next = tail;
		this.tail.prev = this.head;
		map = new HashMap<>(capacity);
	}

	public int get(int key) {
		if(map.containsKey(key)){
			//从map中取出key对应的双向链表中的节点node
			DoubleLinkNode node = map.get(key);
			//在双向链表中删除该节点
			removeNode(node);
			//将该节点插入链表头部
			putFirst(node);
			return node.value;
		}else{
			return -1;
		}
	}

	public void put(int key, int value) {
		if(map.containsKey(key)){
			//put的key已经存在，需要修改值，并将其放入到链表头部
			DoubleLinkNode node = map.get(key);
			//修改值
			node.value = value;
			//删除原来位置上的node
			removeNode(node);
			//插入到头部
			putFirst(node);
		}else{
			//put的key不存在，创建一个新的节点node
			DoubleLinkNode node = new DoubleLinkNode(key,value);
			//将该node放入链表头部
			putFirst(node);
			//在map中放入key,node
			this.map.put(key,node);
			//判断是否已经超出容量，如果超出则需要删除最后一个节点
			if(this.size>this.capacity){
				//删除一个节点
				DoubleLinkNode last = removeLast();
				//删除map中对应的key
				this.map.remove(last.key);
			}
		}
	}

	public void removeNode(DoubleLinkNode node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
		this.size-=1;
	}

	public void putFirst(DoubleLinkNode node){
		if(node == null) return ;
		node.next = this.head.next;
		this.head.next = node;
		node.prev = this.head;
		node.next.prev = node;
		this.size+=1;
	}

	public DoubleLinkNode removeLast(){
		if(this.size <= 0) return null;
		DoubleLinkNode node = this.tail.prev;
		node.prev.next = this.tail;
		this.tail.prev = node.prev;
		this.size-=1;
		return node;
	}
}