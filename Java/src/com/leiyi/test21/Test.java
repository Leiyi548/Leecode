package com.leiyi.test21;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2022/1/7 1:17 下午
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        ListNode l1 = solution.createListNode(n);
        ListNode l2 = solution.createListNode(n);
        ListNode l3 = solution.mergeTwoLists(l1, l2);
        solution.printListNode(l3);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode prevNode = new ListNode(-1);
        ListNode prev = prevNode;
        while(list1 != null && list2 != null){
            if (list1.val<=list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2:list1;
        return prevNode.next;
    }

    public ListNode createListNode(int n) {
        ListNode head = null;
        ListNode tail = null;
        ListNode tmp = null;
        int data;
        System.out.println("createListNode");
        for (int i = 0; i < n; i++) {
            Scanner scanner = new Scanner(System.in);
            data = scanner.nextInt();
            tail = new ListNode(data, null);
            if (head == null) {
                head = tail;
            } else {
                tmp.next = tail;
            }
            tmp = tail;
        }
        return head;
    }

    public void printListNode(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}
