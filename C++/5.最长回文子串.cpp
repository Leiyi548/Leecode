/*
author: Leiyi548
Lences: MIT
date: 2021年-12月-23日
*/
#include <iostream>
#include <string>
using namespace std;
class Solution01 {
public:
  // 暴力法
  string longestPalindrome(string s) {
    string ans = "";
    string subStr = "";
    int n = s.length();
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n - i + 1; j++) {
        if ((n-i+1)<ans.length())continue;
        subStr = s.substr(i, j);
        if (isPalindrome(subStr)) {
          ans = subStr.length() > ans.length() ? subStr : ans;
        }
      }
    }
    return ans;
  }

  bool isPalindrome(string s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s[left] != s[right])
        return false;
      left++;
      right--;
    }
    return true;
  }
};

bool isPalindrome(string s) {
  int left = 0, right = s.length() - 1;
  while (left < right) {
    if (s[left] != s[right])
      return false;
    left++;
    right--;
  }
  return true;
}

int main() {
  string ans;
  string s;
  Solution01 solution;
  cout << "Please input s(string)" << endl;
  cin >> s;
  ans = solution.longestPalindrome(s);
  cout << "longestPalindrome is : " << ans << endl;
  return 0;
}
