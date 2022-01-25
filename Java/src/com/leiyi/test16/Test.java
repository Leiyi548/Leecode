package com.leiyi.test16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2022/1/2 10:48 上午
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, target;
        System.out.println("请输入你要创建数组的大小");
        n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("开始创建数组");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                nums[i] = scanner.nextInt();
            }
        }
        System.out.println("请输入target");
        target = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println("===Answer===");
        System.out.println(solution.threeSumClosest(nums, target));
    }
}

class Solution02 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;
        int tempNumber;
        int distance;
        int minDistance = Integer.MAX_VALUE;
        if (n == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    tempNumber = nums[i] + nums[j] + nums[k];
                    distance = Math.abs(tempNumber - target);
                    ans = distance < minDistance ? tempNumber : ans;
                    minDistance = Math.min(distance, minDistance);
                }
            }
        }
        return ans;
    }
}