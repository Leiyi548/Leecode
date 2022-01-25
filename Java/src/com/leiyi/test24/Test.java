package com.leiyi.test24;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2022/1/9 8:18 下午
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        printListNode(solution.swapPairs(solution.createListNode(5)));
    }

    public static void printListNode(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
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
    public ListNode createListNode(int n) {
        ListNode head = null, tmp = null, tail = null;
        int data;
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始创建链表");
        for (int i = 0; i < n; i++) {
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

    public ListNode swapPairs(ListNode head) {
        ListNode resultHead = new ListNode();
        resultHead.next = head;
        ListNode curNode = resultHead;
        while (curNode != null && curNode.next != null && curNode.next.next != null) {
            ListNode first = curNode;
            ListNode second = first.next;
            ListNode third = second.next;

            // 进行交换
            first.next = third;
            second.next = third.next;
            third.next = second;

            // 标杆为向前进2位
            curNode = curNode.next.next;
        }
        return resultHead.next;
    }
}
