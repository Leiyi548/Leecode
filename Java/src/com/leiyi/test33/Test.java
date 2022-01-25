package com.leiyi.test33;

/**
 * @author Leiyi548
 * @date 2022/1/17 1:09 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new Solution02().search(nums, target));
    }
}

class Solution02 {
    public int search(int[] nums, int target) {
        // 左右指针
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 获得中间值 (mid)
            int mid = left + (right - left) / 2;
            // 查找到内容直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // 翻转之后如果left 到 mid nums[mid]>nums[left] left到mid就是升序的
            //  落在同一个数组的情况,同时落在数组1 或 数组 2
            if (nums[mid] >= nums[left]) {
                // target 落在left和mid之间,则移动我们的right,完全有序的一个区间内寻找
                // 说明target 在left和mid之间,只要移动right就能找到target
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                    // 这个时候说明 后面一组是递增的也就是 mid 到right是递增的,这个时候我们只要移动left就能找到答案
                } else if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                }
                //不落在同一个数组的情况,left在数组1,mid在数组2
                // 翻转之后如果 nums[mid] < nums[left]说明mid是在翻转之间例如
                // 1 2 3 4 7 8 target = 4
                // 7 8 1 2 3 4  nums[mid]= 1 nums[left] = 7
                // 可以看出nums[mid]是 1 而1是小于mid
                // 那么这个时候 mid 就在数组2,left就在数组1
            } else if (nums[mid] < nums[left]) {
                // 由上面可以看出来我要的target如果大于这个时候的mid,因为右边都是递增的,所以往右走
                // left = mid + 1;
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                // 说明这个时候target在左边,往左走
                // right = mid - 1;
                } else if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return ans;
    }
}