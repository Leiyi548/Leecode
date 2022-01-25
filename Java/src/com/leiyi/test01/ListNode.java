package com.leiyi.test01;

/**
 * @author Leiyi548
 * @date 2021/12/28 5:38 下午
 */
public class ListNode {
    /**
     * Definition for singly-linked list.
     */
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
