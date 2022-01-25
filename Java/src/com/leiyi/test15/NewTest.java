package com.leiyi.test15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leiyi548
 * @date 2022/1/4 3:04 下午
 */
public class NewTest {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        SolutionTest solutionTest = new SolutionTest();
        printList(solutionTest.threeSum(nums));

    }

    public static void printList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString() + " ");
        }
    }
}

class SolutionTest {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);//-4,-1,-1,0,1,2
        int first;
        int n = nums.length;
        for (first = 0; first < n - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int left = first + 1;
            int right = n - 1;
            while (left < right) {
                int sumNumber = nums[first] + nums[left] + nums[right];
                if (sumNumber > 0) {
                    right--;
                } else if (sumNumber < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[first], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                }
            }
        }
        return ans;
    }
}
