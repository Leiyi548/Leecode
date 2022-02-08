package com.leiyi.test45;

/**
 * @author Leiyi548
 * @date 2022/1/28 12:20 下午
 */
public class Test {
    public static void main(String[] args) {
        int []arr = {2,3,1,1,4};
        int res = new Solution().jump(arr);
        System.out.println(res);
    }
}

class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int n = nums.length;
        // 一开始是从数组0开始跳的
        // 所以end maxPos初始化为0
        int end = 0;
        int maxPos = 0;
        // 因为最后一个可以不用跳 (我们的目的就是到达数组最后一个位置
        for (int i = 0; i < n-1; i++) {
            // 这里的maxPos就是它能跳的距离位置最大值 当i等于这个maxPos的时候(这是这一步所能跳到最远)
            // 更新能跳到最远的位置,然后再进行下一步
            maxPos = Math.max(nums[i] + i, maxPos);
            if (i == end) {
                // end 下一步的终点
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }
}