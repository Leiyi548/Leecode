package com.leiyi.test40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Leiyi548
 * @date 2022/1/24 8:42 上午
 */
public class Test {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Solution().combinationSum2(candidates, target));
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    // 暴力法
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        int n = candidates.length;
//        Arrays.sort(candidates);
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (candidates[i] + candidates[j] == target) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(candidates[i]);
//                    list.add(candidates[j]);
//                    res.add(list);
//                }
//                for (int k = j + 1; k < n; k++) {
//                    if (candidates[i] + candidates[j] + candidates[k] == target) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(candidates[i]);
//                        list.add(candidates[j]);
//                        list.add(candidates[k]);
//                        res.add(new LinkedList(list));
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer>list = new ArrayList<>();
            dfs(candidates,0,target,list);
            return res;
    }

    private void dfs(int[] candidates, int number, int target, List<Integer> list) {
        // dfs出口
        if (number == target) {
            res.add(new LinkedList<Integer>(list));
            return;
        }
        if (number > target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, number + candidates[i], target, list);
            list.remove(list.size() - 1);
        }
    }
}