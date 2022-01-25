/*
******************************************
Author:Leiyi
Date:27.09.21.
Email:  1424630446@qq.com
Github:  https://github.com/leiyi548
Copyright:2021 All right reserved
Description:
******************************************
*/

#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

//解法一,暴力法,遍历出这个字符串的所有子串然后判断是否是回文串
//能做出来,但是会超出时间
class Solution {
public:
  string longestPalindrome(string s) {
    int n = s.length();
    if (n == 1)
      return s.substr(0, 1);
    int maxLen = 1;
    int start = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int getLen = j - i + 1;
        if (getLen > maxLen && isPalindrome(s, i, j)) {
          start = i;
          maxLen = getLen;
        }
      }
    }
    return s.substr(start, maxLen);
  }

  bool isPalindrome(string s, int start, int end) {
    while (start < end) {
      if (s[start] != s[end]) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
};

//动态规划
// dp[i][j]表示从i到j是回文子串
//有几种情况
// 1.当s[i]和s[j]相等时候 i和j相等就是一个字符肯定是回文字符
// 2.当s[i][j] i和j只相差1的时候,s[i] 和s[j]相等例如aa肯定是回文字符
// 3.dp[i][j]是回文字符那就是s[i]=s[j],dp[i+1][j-1]=true;
class Solution_1 {
public:
  string longestPalindrome(string s) {
    int n = s.length();
    int maxlen = 1;
    int start = 0;
    vector<vector<int>> dp(s.size(), vector<int>(s.size(), 0));
    for (int i = 0; i < n; ++i) {
      dp[i][i] = 1; //情况一
    }
    for (int j = 1; j < n; ++j) {
      for (int i = 0; i < j; ++i) {
        if (s[i] == s[j]) {
          // 首尾相等时，有2种情况
          // 情况1：s[i...j]长度不超过3，不用检查必为回文串
          // 情况2：s[i...j]长度大于3，由s[i+1...j-1]来判断
          if (dp[i + 1][j - 1] == 1 || j - i + 1 <= 3) {
            dp[i][j] = 1;
          }
          if ((j - i + 1) > maxlen && dp[i][j]) {
            maxlen = j - i + 1;
            start = i;
          }
        }
      }
    }
    cout << "start:" << start << "maxlen:" << maxlen << endl;
    return s.substr(start, maxlen);
  }
};

int main() {
  string s;
  Solution_1 solution;
  cout << "------------最长回文字符串------------------" << endl;
  cout << "请输入字符串" << endl;
  cin >> s;
  cout << "answer: " << solution.longestPalindrome(s) << endl;
  return 0;
}
