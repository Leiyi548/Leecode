/*
author: Leiyi548
Lences: MIT
date: 2021年-12月-24日
*/
#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

class Solution {
public:
  string convert(string s, int numRows) {
    string ans = "";
    // 初始化动态数组 min(numRows, int(s.size()))
    // 因为有可能字符串才2个,而行有3个,所以这个时候还是按2个算
    vector<string> rows(min(numRows, int(s.size())));
    bool goingdown = false;
    int currentRow = 0;
    if (numRows < 2) {
      return s;
    }
    for (char c : s) {
      rows[currentRow] += c;
      if (currentRow == 0 || currentRow == numRows - 1) {
        goingdown = !goingdown;
      }
      currentRow += goingdown ? 1 : -1;
    }
    for (string row : rows) {
      ans += row;
    }
    return ans;
  }
};

int main() {
  string s;
  int numRows;
  cout << "please input test string:" << endl;
  cin >> s;
  cout << "please input numRows:" << endl;
  cin >> numRows;
  Solution solution;
  string ans = solution.convert(s, numRows);
  cout << " answer:" << ans << endl;
  return 0;
}
