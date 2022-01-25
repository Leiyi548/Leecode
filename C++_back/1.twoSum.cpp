/*
******************************************
Author:            Leiyi
Date:             22.09.21.
FileName:      
Copyright:      2021 All right reserved
*/

#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

template <class T>
int getArrayLen(T& array){
	return (sizeof(array)/sizeof(array[0]));
}
/*
vector<int> solution(int nums[],int target){
	vector<int> res;
	int left=0;
	int length=getArrayLen(nums)-1;
	int right=length-1;
	sort(nums,nums+length,lesss<>);
	while (left<right) {
		if (nums[left]+nums[right]==target){
			
		}
	}
	return 0;
}
:w
:q
:q
*/

class Solution {
	public:
		//方法一,暴力法 
		/* vector<int> twoSum(vector<int>&nums,int target){ */
		/* 	int i,j; */
		/* 	vector<int>res; */
		/* 	for(int i=0;i<nums.size()-1;i++){ */
		/* 		for(int j=i+1;j<nums.size();j++){ */
		/* 			if(nums[i]+nums[j]==target){ */
		/* 				res.push_back(i); */
		/* 				res.push_back(j); */
		/* 				return res; */
		/* 			} */
		/* 		} */
		/* 	} */
		/* 	return res; */
		/* } */

		vector<int> twoSum(vector<int>&nums,int target){
			unordered_map<int,int>map;
			for (int i = 0; i < nums.size(); ++i) {
				auto it = map.find(target-nums[i]);
				if (it!=map.end()){
					return {it->second,i};
				}
				map[nums[i]]=i;
			}
			return {};
		}
	
};

int main(){
	int nums[4]={2,7,11,15};
	int target = 9;
	vector<int>test=vector<int>(nums,nums+4);
	vector<int>res;
	Solution s;
	
	res=s.twoSum(test, target);
	for (int i=0; i<res.size(); i++) {
		cout<<res[i]<<" ";
	}
  cout<<"hello,world";
	return 0;
}
