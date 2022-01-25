package com.leiyi.test19;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2022/1/5 11:05 上午
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("请输入你要创建链表的长度");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solution.testNode = solution.createListNode(n);
        System.out.println("删除前");
        solution.printListNode(solution.testNode);
        System.out.println("请输入你要删除节点的位置(倒数)");
        int deletePosition = scanner.nextInt();
        solution.removeNthFromEnd(solution.testNode, deletePosition);
        System.out.println("删除后");
        solution.printListNode(solution.testNode);
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
    public ListNode testNode;

    /**
     * 用快慢指针来完成
     * 快指针fast 满指针slow
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        // 让快指针先走
        while(n>0){
            fast = fast.next;
            n--;
        }
        // 快慢指针一起走
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public int Length(ListNode list) {
        int n = 0;
        while (list != null) {
            list = list.next;
            n++;
        }
        return n;
    }

    public void printListNode(ListNode list) {
        while (list != null) {
            System.out.printf(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public ListNode createListNode(int n) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = null;
        ListNode tail = null;
        ListNode tmp = null;
        System.out.println("开始创建链表");
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第" + (i + 1) + "个节点");
            int data = scanner.nextInt();
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
}
