#include <iostream>
#include <unordered_set>
using namespace std;

int main()
{
	unordered_set<string> myset1 = {"yellow","green","blue"};
	cout<<myset1.size()<<endl;
	myset1.insert("yellow");
	cout<<myset1.size()<<endl;
	cout<<myset1.size()<<endl;
	cout<<myset1.empty()<<endl;
	myset1.clear();
	cout<<myset1.size()<<endl;
	return 0;
}
