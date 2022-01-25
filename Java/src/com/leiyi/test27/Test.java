package com.leiyi.test27;

/**
 * @author Leiyi548
 * @date 2022/1/12 3:54 下午
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, 3));
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(nums[i] + " ");
        }
        System.out.println();
    }

}

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < n) {
            if (nums[fast] == val) {
                fast++;
                continue;
            }
            nums[slow] = nums[fast];
            fast++;
            slow++;
        }
        return slow;
    }
}
