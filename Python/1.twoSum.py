class Solution:
    # 暴力法
    # def twoSum(self,nums,target):
    #     for i in range(len(nums)):
    #         for j in range(len(nums)):
    #             if (nums[i]+nums[j]==target):
    #                 return [i,j]

    def twoSum(self, nums, target):
        hashtable = {}
        for i, num in enumerate(nums):
            if target - num in hashtable.keys():
                return [hashtable[target - num], i]
            hashtable[num] = i
        return []


if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    solution = Solution()
    res = solution.twoSum(nums, target)
    print(res)
    print("helloworld")
