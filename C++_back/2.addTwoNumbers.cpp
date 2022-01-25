/*
******************************************
Author:            Leiyi
Date:             22.09.21.
Github:  https://github.com/leiyi548
Copyright:      2021 All right reserved
Description:  This is a leetcode test
******************************************
*/
/*
******************************************
Description: You are given two non-empty linked lists representing two
non-negative integers. The digits are stored in reverse order, and each of their
nodes contains a single digit. Add the two numbers and return the sum as a
inked list.

You may assume the two numbers do not contain any leading zero, except the
number 0 itself.
-----------------------------------------
Example: Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
-----------------------------------------
Demo:
******************************************
*/
/* 342 242   24 123     99 100
 * 342       240 	 	990
 * 242    	 123   		100
 * 584 		 363 		1090
 */
//参考定义一个空链表
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * }
 */
#include <iostream>
#include <malloc/_malloc.h>
using namespace std;
typedef struct node {
  int data;
  struct node *link;
} LNode, *LinkList;
class Solution {
public:
  LinkList l1;
  LinkList l2;
  LinkList l3;
  LinkList Create(int n) {
    LinkList p, r, list = NULL;
    int a;
    cout << "尾插法创建链表中" << endl;
    for (int i = 0; i < n; ++i) {
      cin >> a;
      p = (LinkList)malloc(sizeof(LNode));
      p->data = a;
      p->link = NULL;
      if (list == NULL)
        list = p;
      else
        r->link = p;
      r = p;
    }
    return list;
  }

  LinkList addTwoNumbers(LinkList l1, LinkList l2) {
    int len1 = 1;
    int len2 = 1;
    LinkList p = l1;
    LinkList q = l2;
    while (p->link != NULL) {
      len1++;
      p = p->link;
    }
    while (q->link != NULL) {
      len2++;
      q = q->link;
    }
    if (len1 > len2) {
      for (int i = 0; i < len1 - len2; ++i) {
        q->link = (LinkList)malloc(sizeof(LNode));
        q->link->data = 0;
        q = q->link;
      }
    } else {
      for (int i = 0; i < len2 - len1; ++i) {
        p->link = (LinkList)malloc(sizeof(LNode));
        p->link->data = 0;
        p = p->link;
      }
    }
    p = l1;
    q = l2;
    bool count = false;
    LinkList l3 = (LinkList)malloc(sizeof(LNode));
    l3->data = 0;
    l3->link = NULL;
    LinkList w = l3;
    while (p != NULL && q != NULL) {
      LinkList node = (LinkList)malloc(sizeof(LNode)); //创建一个新节点
      int val = (p->data + q->data + count);
      node->data = val % 10;
      count = val >= 10 ? true : false;
      w->link = node;
      p = p->link;
      q = q->link;
      w = w->link;
    }
    // 最后还有进位的话就加一
    if (count) {
      LinkList node = (LinkList)malloc(sizeof(LNode));
      node->link = NULL;
      node->data = 1;
      w->link = node;
      w = w->link;
    }
    return l3->link;
  }
  void PritList(LinkList p) {
    while (p != NULL) {
      cout << p->data << " ";
      p = p->link;
    }
    cout << endl;
  }
};

int main() {
  LinkList l1;
  LinkList l2;
  int len1, len2;
  Solution s;
  cout << "请输入你要创建链表一的长度" << endl;
  cin >> len1;
  s.l1 = s.Create(len1);
  cout << "请输入你要创建链表二的长度" << endl;
  cin >> len2;
  s.l2 = s.Create(len2);
  s.l3 = s.addTwoNumbers(s.l1, s.l2);
  cout << "hello,world" << endl;
  s.PritList(s.l3);
  return 0;
}
