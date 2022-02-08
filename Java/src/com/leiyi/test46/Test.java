package com.leiyi.test46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Leiyi548
 * @date 2022/2/5 8:37 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = new ArrayList<>();
        res = new Solution().permute(nums);
        System.out.println(res);
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        dfs(nums, used, new LinkedList<Integer>());
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果被使用了直接跳过
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, used, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
