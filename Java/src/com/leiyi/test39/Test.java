package com.leiyi.test39;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leiyi548
 * @date 2022/1/23 11:52 上午
 */
public class Test {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> list = new Solution().combinationSum(candidates, target);
        System.out.printf("List: " + list);
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(candidates, list, 0, target,0);
        return res;
    }

    public void dfs(int[] candidates, List<Integer> list, int num, int target,int startIndex) {
        int n = candidates.length;
        // dfs出口
        if (num == target) {
            List<Integer> ans = new ArrayList<>(list);
            res.add(ans);
            return;
        }
        if (num > target) {
            return;
        }
        // 遍历每个数字
        for (int i = startIndex; i < n; i++) {
            list.add(candidates[i]);
            dfs(candidates, list, num + candidates[i], target,i);
            list.remove(list.size() - 1);
        }
    }
}