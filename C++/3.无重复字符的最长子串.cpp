/*
author: Leiyi548
Lences: MIT
date: 2021年-12月-21日
*/
#include <iostream>
#include <math.h>
#include <unordered_set>
using namespace std;

class Solution {
public:
  int lengthOfLongestSubstring(string s) {
    int ans = 0;
    unordered_set<int> set;
    // 定义右指针
    int right = -1;
    int n = s.length();
    for (int i = 0; i < s.length(); i++) {
      if (i != 0) {
        set.erase(s[i - 1]);
      }
      // 1.当右指针没有越界 2.最后一个没有出现2次就行
      // right + 1 下个要指向的位置
      while (right + 1 < n && !set.count(s[right+1])) {
        set.insert(s[right + 1]);
        right++;
      }
      ans = max(ans, right - i + 1);
    }
    return ans;
  }
};

int main(int argc, char *argv[]) {
  string s ;
  int ans;
  Solution solution;
  cout<<"please input test string:"<<endl;
  cin >> s;
  ans = solution.lengthOfLongestSubstring(s);
  cout << "ans: " << ans << endl;
  return 0;
}
