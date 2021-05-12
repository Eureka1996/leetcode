package com.wufuqiang.leetcode.mianshiti;

import com.wufuqiang.leetcode.entries.ListNode;
import lombok.val;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-12 22:06
 */
public class MS02_01_RemoveDuplicateNodes {
    public static void main(String[] args) {

    }
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode tmp = head;
        ListNode prev = tmp;
        while(tmp != null){
            if(!set.contains(tmp.val)){  //不包含
                set.add(tmp.val);
                prev = tmp;
            }else{
                prev.next = tmp.next;
            }
            tmp = tmp.next;
        }

        return head;
    }
}
