package com.leiyi.test34;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leiyi548
 * @date 2022/1/18 3:40 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] testNums = {};
        int target = 7;
        int[] ans = new Solution02().searchRange(nums, target);
        for (int i = 0; i < ans.length; i++) {
            System.out.printf(ans[i] + " ");
        }
    }
}

class Solution02 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int low = lowBound(nums,target);
        int high = highBound(nums,target);
        if (high < low){
            return new int []{-1,-1};
        }
        return new int[]{low,high};
    }

    //计算下边界
    private int lowBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]){
                right = mid - 1;
            }else if (target > nums[mid]){
                left = mid + 1;
            }
        }
        return left;
    }

    //计算上边界
    private int highBound(int[]nums,int target){
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }
        }
        return right;
    }
}

class Solution {
    /**
     * 暴力法
     *
     * @param nums   排序数组 (升序)
     * @param target (自己要查找的值)
     * @return (返回找到知道下标)(int [])
     */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int firstPosition = -1, secondPosition = -1;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == target && firstPosition == -1) {
                firstPosition = i;
            }
            if (nums[i] == target && firstPosition != -1) {
                secondPosition = i;
                break;
            }
        }
        return new int[]{firstPosition, secondPosition};
    }
}