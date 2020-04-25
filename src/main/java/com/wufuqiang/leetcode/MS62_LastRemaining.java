package com.wufuqiang.leetcode;

//约瑟夫环 报数 圆圈中的最后一个数
public class MS62_LastRemaining {
	public static void main(String[] args) {
		MS62_LastRemaining test = new MS62_LastRemaining();
		test.lastRemaining(10,17);
	}
	public int lastRemaining(int n, int m) {
		int result = 0 ;
		LinkNode root = new LinkNode();
		root.val = 0;
		LinkNode preNode = root;
		LinkNode start = null;
		for(int i = 1;i<n;i++){
			LinkNode cur = new LinkNode();
			cur.val = i;
			preNode.next = cur;
			preNode = cur;
		}
		preNode.next = root;
		start = preNode;
		int count = n;
		while(n>1){
			int tm = m % n;
			for(int i = 0;i<tm-1;i++){
				start = start.next;
			}
			n-=1;
			start.next = start.next.next;
		}

		System.out.println(start.val);
		return start.val;

	}

	public int lastRemaining2(int n, int m) {
		//最后一个数的下标为0
		int ans = 0;
		for(int i = 2 ;i<=m;i++){
			ans = (ans+m)%i;
		}
		return ans;
	}

}

class LinkNode{
	public int val;
	public LinkNode next;
}
