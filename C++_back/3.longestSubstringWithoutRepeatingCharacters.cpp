/*
******************************************
Author:Leiyi
Date:23.09.21.
Email:  1424630446@qq.com
Github:  https://github.com/leiyi548
Copyright:2021 All right reserved
Description: This is a simple leetcode test
******************************************
*/
/*
******************************************
Description: Given a string s, find the length of the longest substring without repeating characters.
-----------------------------------------
Example:Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Demo:
******************************************
*/
#include <cstring>
#include <iostream>
#include <string>
#include <algorithm>
#include <unordered_set>
#include <math.h>
using namespace std;
//暴力法 abcd
//ab abc abcd bc bcd cd
class Solution{
	public:
		int lengthOfLongestSubstring(string s){
			if (s.length()==0)return 0;
			int longestLen=1;
			int length = s.length();
			for (int i = 0; i < length; ++i) {
				for(int j = i+1 ;j<length;++j){
					if (allUnique(s, i, j)){
						int tempLen=j-i+1;
						if (tempLen>longestLen){
							longestLen=tempLen;
						}
					}
				}
			}
			return longestLen;
		
		}

		// 先将字符串转换成数组,然后从小到大来排序,然后进行判断是否会重复
		bool allUnique(string s,int start,int end){
			char *a;
			int len = end - start + 1;
			a = stringToChar(s, start, end);
			sort(a,a+len);
			for(int i=0;i<len-1;i++){
				if (a[i+1]==a[i]){
					return false;
				}
			}
			return true;
		}

		char* stringToChar(string s,int start,int end){
			int len = end - start + 1;
			char *a = new char [len];
			int index=0;
			for (int i = start; i <= end; i++) {
				a[index]=s[i];
				index++;
			}
			return a;
		}

};
class Solution01{
	public:
	int lengthOfLongestSubstring(string s){
		int n = s.length();
		if (n<2)return n;
		int res=0;
		unordered_set<char>occ;	
		for (int i = 0; i < n; ++i) {
			for(int j = i;j<n;++j){
				if(occ.count(s[j])){
					break;
				}
				else{
					occ.insert(s[j]);
				}
			}
			res=max(int(occ.size()),res);
			occ.clear();
		}
		return res;
	}

};

//abcabcbb
//abc bca cab abc bcb cb b b
//滑动窗口
class Solution02{
	public:
		int lengthOfLongestSubstring(string s){
			int n = s.length();
			int ans = 0;
			if(n<2)return n;
			int right=0;//代表右指针还没有动
			unordered_set<char>occ;
			for (int i = 0; i < n; ++i) {
				//开始新的窗口,移除上个窗口的起始数据
				if (i!=0){
					occ.erase(s[i-1]);
				}
				while(right<n && !occ.count(s[right])){
					occ.insert(s[right]);
					right++;
				}
				ans=max(ans,int(occ.size()));
			}
		return ans;
		}
};

int main()
{
	int start,end;
	string s;
	int res;
	cout<<"-----------无重复最长字符串-----------"<<endl;
	cout<<"请输入字符串"<<endl;
	cin>>s;
	//暴力法1
	/* Solution solution; */
	/* res = solution.lengthOfLongestSubstring(s); */
	/* cout<<res<<endl; */
	//暴力法2
	/* Solution01 s1; */
	/* res = s1.lengthOfLongestSubstring(s); */
	Solution02 s2;
	res = s2.lengthOfLongestSubstring(s);
	cout<<"answer: "<<res<<endl;
  cout<<"hello"<<endl;
  cout<<"你好啊"<<endl;
	return 0;
}
