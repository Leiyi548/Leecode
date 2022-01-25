package com.leiyi.test40;

import java.util.*;

/**
 * @author Leiyi548
 * @date 2022/1/24 8:42 上午
 */
public class Test {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = new ArrayList<>();
        res = new Solution().combinationSum2(candidates, target);
        System.out.println(res);
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> deque = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 为了把重复的数字都放在一起,先进行排序
        Arrays.sort(candidates);
        // 加标签数组,用来辅助判断同层节点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        backTracking(candidates, target, 0, 0, flag);
        return res;
    }

    private void backTracking(int[] arr, int target, int sum, int index, boolean[] flag) {
        if (sum == target) {
            res.add(new ArrayList(deque));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < arr.length && arr[i] + sum <= target; i++) {
            // 出现重复节点,同层的第一个节点已经被访问过了,所以直接跳过
            // 为什么是!flag[i-1] 比如 [1,1,2,5,6,7,10]
            // 我们第一层有两个1,所以我们第二个1其实不用,所以回溯回去flag那个时候全部都是false,所以是!flag[i-1]
            if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            deque.push(arr[i]);
            //每个节点只能选择一次,所以从下一位开始
            backTracking(arr, target, sum + arr[i], i + 1, flag);
            int temp = deque.pop();
            // 还原
            flag[i] = false;
        }
    }

}