/*
author: Leiyi548
Lences: MIT
date: 2021年-12月-19日
*/

/*
  解题思路:
*/
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
public:
  vector<int> twoSumWay1(vector<int> &nums, int target) {
    vector<int> res;
    for (unsigned int i = 0; i < nums.size(); ++i) {
      int nums_temp = target - nums[i];
      for (unsigned int j = i + 1; j < nums.size(); ++j) {
        if (nums_temp == nums[j]) {
          res.push_back(i);
          res.push_back(j);
        }
      }
    }
    return res;
  }

  vector<int> twoSumWay2(vector<int> &nums, int target) {
    unordered_map<int, int> hashtable;
    for (int i = 0; i < nums.size(); i++) {
      auto it = hashtable.find(target - nums[i]);
      if (it != hashtable.end()) {
        return {it->second, i};
      }
      hashtable[nums[i]] = i;
    }
    return {};
  }
};

void printfList(int a[], int n) {
  for (int i = 0; i < n; i++) {
    cout << a[i] << endl;
  }
}

void printfVecotor(vector<int> v) {
  for (unsigned int i = 0; i < v.size(); ++i) {
    cout << v[i] << " ";
  }
  cout << endl;
}

void printUnorderedMap(unordered_map<int, string> map) {
  auto iter = map.begin();
  while (iter != map.end()) {
    cout << iter->first << "," << iter->second << endl;
    ++iter;
  }
}

int main() {
  int data[4] = {2, 7, 11, 15};
  vector<int> nums = vector<int>(data, data + 4);
  vector<int> res;
  Solution s;
  res = s.twoSumWay2(nums, 9);
  printfVecotor(res);
  return 0;
}
