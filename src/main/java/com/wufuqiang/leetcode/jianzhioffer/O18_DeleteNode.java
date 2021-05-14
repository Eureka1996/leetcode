package com.wufuqiang.leetcode.jianzhioffer;

import com.wufuqiang.leetcode.entries.ListNode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-14 19:43
 */
public class O18_DeleteNode {
    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode headTmp = new ListNode(val+1);
        headTmp.next = head;
        ListNode current = head;
        ListNode prev = headTmp;
        while(current != null){
            if(current.val == val){
                prev.next = current.next;
                break;
            }else{
                current = current.next;
                prev = prev.next;
            }
        }
        return headTmp.next;
    }

}
