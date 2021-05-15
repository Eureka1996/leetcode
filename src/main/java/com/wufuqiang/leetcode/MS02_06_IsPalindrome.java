package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-15 11:32
 */
public class MS02_06_IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }else{
                break;
            }
            slow = slow.next;
        }
        ListNode halfTmp = new ListNode(0);
//        slow = slow.next;
        ListNode next = slow;
        while(slow != null){
            next = slow.next;
            slow.next = halfTmp.next;
            halfTmp.next = slow;
            slow = next;
        }

        boolean flag = true;
        halfTmp = halfTmp.next;
        while(halfTmp != null){
            if(halfTmp.val != head.val){
                flag = false;
                break;
            }
            halfTmp = halfTmp.next;
            head = head.next;
        }
        return flag;
    }
}
