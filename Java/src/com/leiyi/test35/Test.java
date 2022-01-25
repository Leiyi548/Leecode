package com.leiyi.test35;

/**
 * @author Leiyi548
 * @date 2022/1/19 1:00 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        System.out.println(new Solution().searchInsert(nums, target));
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
