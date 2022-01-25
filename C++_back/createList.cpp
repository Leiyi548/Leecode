#include <iostream>
#include <malloc/_malloc.h>
using namespace std;

typedef struct node{
	int data;
	struct node * link;
}LNode,*LinkList;


LinkList Create(int n){
	LinkList p,r,list=NULL;
	int a;
	for (int i = 0; i < n; ++i) {
		cin>>a;
		p=(LinkList)malloc(sizeof(LNode));
		p->data=a;
		p->link=NULL;
		if (list==NULL)
			list=p;
		else
			r->link=p;	
		r=p;
	}
	return list;
}

LinkList Create_head(int n){ //头插法和尾插法会有区别,相反输出
	int a;
	LinkList head;
	head=(LinkList)malloc(sizeof(LNode));
	LinkList node=NULL;
	head->link=NULL; //将最后一个结点的指针域永远保持为NULL
	node = head->link;
	cout<<"开始创建新链表"<<endl;
	for (int i = 0; i < n; ++i) {
		cin>>a;
		node = (LinkList)malloc(sizeof(LNode));
		node->data=a;
		node->link=head->link;
		head->link=node;
		
	}
	return head->link;
}

int Length(LinkList list){
	LinkList p = list;
	int n = 0;
	while (p!=NULL) {
		n++;
		p=p->link;
	}
	return n;
}

int IsEmpty(LinkList list){
	return list==NULL;
}

void printList(LinkList list){
	while(list!=NULL){
		cout<<list->data<<" ";
		list=list->link;
	}
	cout<<endl;
}

int main()
{
	int n;
	cout<<"请输入你要创建的链表的大小"<<endl;
	cin>>n;
	//LinkList list = Create(n);
	LinkList list= Create_head(n);
	cout<<"链表长度为"<<Length(list)<<endl;
	cout<<"输出链表"<<endl;
	printList(list);
	return 0;
}
