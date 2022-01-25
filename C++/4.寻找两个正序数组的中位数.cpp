/*
author: Leiyi548
Lences: MIT
date: 2021年-12月-22日
*/
#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
  double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
    vector<int> res;
    double ans = 0;
    res.insert(res.end(), nums1.begin(), nums1.end());
    res.insert(res.end(), nums2.begin(), nums2.end());
    sort(res.begin(), res.end());
    int sumSize = res.size();
    ans = sumSize % 2 ? double(res[sumSize / 2])
                      : double(res[sumSize / 2] + res[sumSize / 2 - 1]) / 2;
    // if (sumSize % 2 == 0) {
    //   ans = double(res[sumSize / 2] + res[sumSize / 2 - 1]) / 2;
    // } else {
    //   ans = double(res[sumSize / 2]);
    // }
    return ans;
  }
  void printfVector(vector<int> v) {
    cout << "Printf Information of vector" << endl;
    for (int i = 0; i < v.size(); i++) {
      cout << v[i] << " ";
    }
    cout << endl;
  }
};
int main() {
  int nums1[] = {1, 3};
  int nums2[] = {2};
  double ans;
  vector<int> nums1Vector = vector<int>(nums1, nums1 + 2);
  vector<int> nums2Vector = vector<int>(nums2, nums2 + 1);
  Solution s;
  ans = s.findMedianSortedArrays(nums1Vector, nums2Vector);
  cout << "ans: " << ans << endl;
  return 0;
}
