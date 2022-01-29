package com.leiyi.test42;

/**
 * @author Leiyi548
 * @date 2022/1/26 11:42 上午
 */
public class Test {
    public static void main(String[] args) {
        int []height = { 0,1,0,2,1,0,1,3,2,1,2,1 };
        int result = new Solution().trap(height);
        System.out.println("result: " + result);
    }
}

class Solution {
    /**
     * 暴力法
     * @param height 高度数组
     * @return 返回能接雨水的最大值
     */
    public int trap(int[] height) {
        int maxArea = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tempArea = Math.min(height[i],height[j])*(j-i);
                maxArea = Math.max(tempArea,maxArea);
            }
        }
        return maxArea;
    }
}
