package com.leiyi.test11;

/**
 * @author Leiyi548
 * @date 2021/12/28 4:22 下午
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(arr));

        Solution02 solution02 = new Solution02();
        System.out.println(solution02.maxArea(arr));
    }
}

class Solution {


    /**
     * 暴力法
     *
     * @param height int[]
     * @return int
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }
}

class Solution02 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        while(left<right){
            maxArea = Math.max(maxArea,(right-left)*Math.min(height[left],height[right]));
            if (height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}