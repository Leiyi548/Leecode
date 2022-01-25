package com.leiyi.test26;

/**
 * @author Leiyi548
 * @date 2022/1/11 10:32 下午
 */
public class Test {
    public static void main(String[] args) {
        int []nums = {1,1,2};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int arrayLength;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast]!=nums[fast-1]){
                nums[slow++] = nums[fast];
            }
            ++fast;
        }
        return slow;
    }
}
