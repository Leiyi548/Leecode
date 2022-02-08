package com.leiyi.test47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Leiyi548
 * @date 2022/2/6 9:04 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = new ArrayList<>();
        res = new Solution().permuteUnique(nums);
        System.out.println(res);
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        // 将数组进行排序,然后这样子的话就能够更好跳过重复的元素
        // 例如 1 1 2
        // 只要 while(nums[i] == nums[i-1]) i++ 就能跳过这些重复的元素
        Arrays.sort(nums);
        dfs(nums, used, new LinkedList<Integer>());
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> path) {
        // dfs出口
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果这个被使用过,直接跳过
            if (used[i]) {
                continue;
            }
            // 剪枝条件
            // 1.一开始的第一个不需要判断是否有重复
            // 2.不重复数据,因为数组是排序好的,所以nums[i] == nums[i-1]那就是重复需要跳过
            // 3.!used[i-1] 是因为 nums[i-1]在dfs的过程中会撤销刚刚的选择
            // !used[i-1]这个重复的数字有可能是上一层的,所以要上一层不要用这个数字才跳过
            // 意思就是选中过的单词不需要再进行判断是否是重复,所以我们就忽略上一层选过的数字
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // 如果被使用了直接跳过
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, used, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
