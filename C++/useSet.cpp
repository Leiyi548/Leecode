#include <iostream>
#include <string>
#include <unordered_set>
using namespace std;

void printfSet(unordered_set<string> set) {
  cout << "printf unordered_set information" << endl;
  unordered_set<string>::iterator it;
  for (it = set.begin(); it != set.end(); it++) {
    cout << *it << ",";
  }
  cout << endl;
}
int main() {
  unordered_set<string> set;
  set.insert("1");
  set.insert("2");
  set.insert("2");
  set.insert("3");
  set.insert("4");
  printfSet(set); // 1 2 3 4
  set.erase("2"); // 1 3 4
  cout << "unordered_set size is " << set.size() << endl; // unordered_set size is 3
  string findNumber;
  cout << "Please Input findNumber" << endl;
  cin >> findNumber;
  if (set.count(findNumber)) { // 找到返回1 没有返回0
    cout << "having this number" << endl;
  } else
    cout << "NO NUMBER!!!" << endl;
  return 0;
}
