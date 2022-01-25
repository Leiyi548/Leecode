/*
******************************************
Author:Leiyi
Date:26.09.21.
Email:  1424630446@qq.com
Github:  https://github.com/leiyi548
Copyright:2021 All right reserved
Description: 加油!!!
******************************************
*/

#include<iostream>
#include<vector>
#include<algorithm>

//1 ,2 ,3 ,4 ,5           3
//1 , 2 ,3, 4, 5,6  3+4/2=3.5
using namespace std;
class Solution{
	public:
		double findMedianSortedArrays(vector<int>&nums1,vector<int>&nums2){
			int m,n;
			m = nums1.size();
			n = nums2.size();
			int sum = m+n;
			double res;
			

			for(int i = 0;i<n;i++){
				nums1.push_back(nums2[i]);
			}
			sort(nums1.begin(),nums1.end());
			int middle = (m+n)/2;
			if(sum%2==0){
				res = nums1[middle]+nums1[middle-1];
				return res/2;
			}
			return nums1[middle];
		}

		void printVector(vector<int>nums){
			for(int i = 0;i<nums.size();i++){
				cout<<nums[i]<<" ";
			}
			cout<<endl;
		}

};

// 1 2 3 3 4 4 5 5 6 6 7 
int main()
{
	int a[]={1,2,3,4,5,6};
	int b[]={3,4,5,6,7};
	double res;
	vector<int> nums1(a,a+6);
	vector<int> nums2(b,b+5);
	Solution s;
	cout<<"nums1:";
	s.printVector(nums1);
	cout<<"nums2:";
	s.printVector(nums2);
	res=s.findMedianSortedArrays(nums1, nums2);
	cout<<res<<endl;
	return 0;
}
