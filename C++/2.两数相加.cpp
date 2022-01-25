#include <iostream>
using namespace std;

// Definition for singly-linked list.
struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
  ListNode *addTwoNumbers_way1(ListNode *l1, ListNode *l2) {
    ListNode *res = NULL;
    ListNode *p = l1;
    ListNode *q = l2;
    int len1 = 0, len2 = 0;
    while (p != NULL) {
      p = p->next;
      len1++;
    }
    while (q != NULL) {
      q = q->next;
      len2++;
    }
    if (len1 > len2) {
      for (int j = 0; j < (len1 - len2); j++) {
        q->next = (ListNode *)malloc(sizeof(ListNode));
        q->next->val = 0;
        q = q->next;
      }
    } else if (len2 > len1) {
      for (int j = 0; j < (len2 - len1); j++) {
        p->next = (ListNode *)malloc(sizeof(ListNode));
        p->next->val = 0;
        p = p->next;
      }
    }
    ListNode *l3 = (ListNode *)malloc(sizeof(ListNode));
    l3->val = 0;
    l3->next = NULL;
    res = l3;
    bool carry = false;
    while (l1 != NULL && l2 != NULL) {
      ListNode *temp = (ListNode *)malloc(sizeof(ListNode));
      int value = l1->val + l2->val + carry;
      carry = value >= 10 ? true : false;
      temp->val = value % 10;
      l3->next = temp;
      l1 = l1->next;
      l2 = l2->next;
      l3 = l3->next;
    }
    if (carry) {
      ListNode *temp = (ListNode *)malloc(sizeof(ListNode));
      temp->val = 1;
      l3->next = temp;
      l3 = l3->next;
    }
    return res->next;
  }
};

int ListNodeLength(ListNode *p) {
  int n = 0;
  while (p != NULL) {
    n++;
    p = p->next;
  }
  return n;
}
void printfListNode(ListNode *p) {
  ListNode *list = p;
  cout << "开始打印链表" << endl;
  while (list != nullptr) {
    cout << list->val << " ";
    list = list->next;
  }
  cout << endl << "链表打印完毕" << endl;
}

ListNode *createListNode(int n) {
  ListNode *p, *r, *list = NULL;
  int a;
  for (int i = 1; i <= n; i++) {
    cout << "输入第" << i << "个节点" << endl;
    cin >> a;
    p = (ListNode *)malloc(sizeof(ListNode));
    p->val = a;
    p->next = nullptr;
    if (list == NULL) {
      list = p;
    } else {
      r->next = p;
    }
    r = p;
  }
  return list;
}
int main() {
  int m, n;
  Solution s;
  ListNode *result;

  cout << "请输入你要创建链表1的长度" << endl;
  cin >> n;
  ListNode *l1 = createListNode(n);
  cout << "请输入你要创建链表2的长度" << endl;
  cin >> m;
  ListNode *l2 = createListNode(m);
  // result = s.addTwoNumbers(l1, l2);
  printfListNode(result);
  return 0;
}
