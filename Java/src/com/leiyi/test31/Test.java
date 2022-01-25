package com.leiyi.test31;

import java.util.Arrays;

/**
 * @author Leiyi548
 * @date 2022/1/15 12:08 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 5, 3};
        int[] testNums = {2,2};
        new Solution().nextPermutation(testNums);
        printArray(testNums);
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(nums[i] + " ");
        }
        System.out.println();
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // 特殊请况,一个数字不用排序
        if (n == 1) {
            return;
        }
        // 从后往前找到第一个递减的两个数字(相邻)
        // 1    2      4       3
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 因为后面是逆序的所以反转就是正序正好是sort(从小到大)
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
