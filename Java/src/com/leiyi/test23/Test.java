package com.leiyi.test23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leiyi548
 * @date 2022/1/11 8:49 下午
 */
public class Test {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 按照顺序两两合并链表,合并k次就得到答案(一开始先跟空地列表进行比较所以是k-1 + 1 = k )
     * @param lists 一个链表数组,每个链表都已经按照升序排列
     * @return 将所有链表合并到一个升序链表,返回这个升序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }

    /**
     * 合并两个链表,按照升序
     * @param a 第一个链表
     * @param b 第二个链表
     * @return 合并链表
     */
    private ListNode mergeTwoLists(ListNode a,ListNode b){
        // 如果a和b中任意一个为空的话,就返回另一个链表
        if (a==null || b == null){
            return a != null ? a:b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head,aPoint = a,bPoint = b;
        while(aPoint != null && bPoint != null){
            if(aPoint.val < bPoint.val){
                tail.next = aPoint;
                aPoint = aPoint.next;
            }else{
                tail.next = bPoint;
                bPoint = bPoint.next;
            }
            tail = tail.next;
        }
        tail.next = (aPoint != null ? aPoint:bPoint);
        return head.next;
    }
}
