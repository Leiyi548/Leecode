package com.leiyi.test15;

import java.util.*;

/**
 * @author Leiyi548
 * @date 2022/1/1 11:06 上午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        Solution02 solution02 = new Solution02();
        printList(solution02.threeSum(nums));
    }
    public static void printList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).toString() + " ");
        }
    }
}

/**
 * 暴力法
 */
class Solution02 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 返回空列表
        if (nums == null || nums.length < 3){
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if ( nums[i]+nums[j]+nums[k]==0){
                        List<Integer>list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}

class Solution {
    public void printList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).toString() + " ");
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 先从小到大排序好
        Arrays.sort(nums);
        // 初始化
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // first 左指针
        // 枚举第一个数字
        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // third 右指针
            int third = n - 1;
            // first + second + third = 0
            // first = - (second + third)
            // target = (second + third)
            int target = -nums[first];
            // 枚举第二数字
            for (int second = first + 1; second < n; ++second) {
                // 保证每次枚举的数字不一样 而且要在第一个数字的右边
                if (second > first + 1 && nums[second] == nums[second + 1]) {
                    continue;
                }
                // 让第二个数字在第三个数字的左边
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
