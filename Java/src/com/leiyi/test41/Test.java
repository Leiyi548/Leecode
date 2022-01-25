package com.leiyi.test41;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Leiyi548
 * @date 2022/1/25 2:00 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {-1,-2,7,3,2,1};
        int res = new Solution03().firstMissingPositive(nums);
        System.out.println(res);
    }
}

class Solution03 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 这里用while是因为交换回来的值不一定是"值配其位"的，那么就可能还需要进行交换
            // 比如[4,1,2,3]
            // 1.第一次将4与3交换，形成[3,1,2,4]，明显3是"值不配位"的，也满足条件，进入新的交换
            // 2.第二次将3与2交换，形成[2,1,3,4]，明显2也是"值不配位"的，且满足条件，进入新的交换
            // 3.第三次将2与1交换，形成[1,2,3,4]，值全都配位了，后面的while也就都不会进了
            // (此处也说明while循环不会每一次都把数组里面的所有元素都看一遍。如果有一些元素在这一次的循环中
            // 被交换到了它们应该在的位置，那么在后续的遍历中，由于它们已经在正确的位置上了，代码再执行到它们
            // 的时候，就会被跳过。----引用自@liweiwei1419的题解)
            //**所以此处不能用if**
            // num[i]-1 因为这是要配位的,例如正常是 1 2 3 4 所以num[i]-1 就对应数组的下标
            // nums[nums[i]-1] == ? nums[i]就是判断是否符合这个配对
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                //将出现的值都交换到相应的位置上，组成一个近似排序的数组
                //其中的负数和大于数组长度的值都可以不用管，因为它是作为一个出口存在的
                //这里值1放在索引0上，即值(i)需要放在索引(i-1)上
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 全部满足条件返回 n + 1 (数组长度+1)
        return n + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Solution02 {
    /**
     * 二分查找法
     *
     * @param nums 未排序的整数数组(注意)有负数
     * @return 其中没有出现的最小的正整数
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i <= n; i++) {
            int res = binarySearch(nums, i);
            if (res == -1) {
                return i;
            }
        }
        // 1 2 3 4 5 6
        return n + 1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

class Solution {
    /**
     * 暴力法
     *
     * @param nums 未排序的整数数组(注意)有负数
     * @return 其中没有出现的最小的正整数
     */
    public int firstMissingPositive(int[] nums) {
        int start = 1;
        // 先排序
        Arrays.sort(nums);
        // 排除重复数字请况
        HashSet<Integer> set = new HashSet<>();
        // 找到第一个出现正整数的下标
        int firstPositiveIndex = findFirstPositive(nums);

        while (firstPositiveIndex < nums.length && start == nums[firstPositiveIndex]) {
            while (firstPositiveIndex < nums.length && nums[firstPositiveIndex] == nums[firstPositiveIndex - 1]) {
                firstPositiveIndex++;
            }
            start++;
            firstPositiveIndex++;
        }
        return start;
    }

    private int findFirstPositive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return i;
            }
        }
        return 0;
    }
}
