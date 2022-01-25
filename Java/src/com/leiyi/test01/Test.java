package com.leiyi.test01;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2021/12/28 5:38 下午
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = solution.createListNode(3);
        solution.printList(list);
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义头尾节点
        ListNode head = null, tail = null;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1){
            tail.next = new ListNode(1);
        }
        return head;
    }


    public ListNode createListNode(int n) {
        // 定义三个节点
        ListNode head = null;
        ListNode tail = null;
        ListNode temp = null;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            tail = new ListNode(number, null);
            if (head == null) {
                head = tail;
            } else {
                temp.next = tail;
            }
            temp = tail;
        }
        return head;
    }

    public void printList(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
            System.out.println();
        }
    }
}
