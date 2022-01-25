#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

string subStr(string s, int start, int end) {
  string res = "";
  int length = end - start + 1;
  for (int i = 0; i < length; i++) {
    res[i] = s[start + i];
  }
  return res;
}

void printfVector(vector<int> v) {
  for (int i = 0; i < v.size(); i++) {
    cout << v[i] << " ";
  }
  cout << endl;
}

int main() {
  unordered_set<int>test;
  test.insert(1);
  test.insert(2);
  test.insert(3);
  test.insert(4);
  test.erase(2);
}
