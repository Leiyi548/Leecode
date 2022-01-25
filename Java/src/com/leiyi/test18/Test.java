package com.leiyi.test18;

import java.util.*;

/**
 * @author Leiyi548
 * @date 2022/1/4 11:35 上午
 */
public class Test {
    public static void main(String[] args) {
        int target = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组的大小");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("开始创建数组");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("请输入target");
        target = scanner.nextInt();
        Solution solution = new Solution();
        Solution02 solution02 = new Solution02();
        solution.printList(solution02.fourSum(arr, target));
    }
}

class Solution02 {
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private int tmpNumber;
    private int left;
    private int right;

    /**
     * 1.先将数组进行排序
     * 2.再固定两个数字,四数之和就变成了两数之和,我们就可以用双指法来做了
     * 3. 固定两个数字之和我们把他定义为tmpNumber; 另外两个指针在一起的数之和就是target-tmpNumber.
     * 另为两个数字我就把他定义为leftNumber和rightNumber
     * leftNumber + rightNumber = target 就返回答案
     * leftNumber + rightNumber < target 就leftNumber++;
     * leftNumber + rightNumber > target 就rightNumber++;
     *
     * @param nums   数组
     * @param target 目标
     * @return int[]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        // 固定两个数字
        // 第一个数字,因为是四数之和,所以最后一个位置是在倒数第四个所以是 nums.length-4
        for (int i = 0; i < nums.length - 3; i++) {
            // i>0是因为第一个数没法比,第一个前面肯定没有重复的数字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //第二个数字
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 同上将重复数字给移除掉
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                tmpNumber = nums[i] + nums[j];
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    int sumNumber = tmpNumber + nums[left] + nums[right];
                    if (sumNumber < target) {
                        left++;
                    } else if (sumNumber > target) {
                        right--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 得到结果后也要进行排除重复的,避免多次加入
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
        }
        return ans;
    }
}

class Solution {
    private List<List<Integer>> list = new ArrayList<List<Integer>>();

    public int[] weightRemoval(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            result[i] = integer;
            ++i;
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        /**
         * 1.先将数组进行排序
         * 2.四个数字分别用a b c d 表示 a+b+c+d = target
         * 3.先定下一个数字,然后再用指针来做.
         */
        if (nums.length < 2) {
            return list;
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[k]);
                            tmp.add(nums[l]);
                            set.add(tmp);
                        }
                    }
                }
            }
        }
        return new ArrayList(set);
    }

    public void printList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
