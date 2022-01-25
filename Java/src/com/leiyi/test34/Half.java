package com.leiyi.test34;

/**
 * @author Leiyi548
 * @date 2022/1/18 10:31 下午
 */
public class Half {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6, 8, 12, 14, 16};
        int target = 8;
        int ans = search(nums,target);
        System.out.println(ans);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        if (n == 0) {
            return -1;
        }
        while (left <= right) {
            // 这种写法可能会溢出,为了防止溢出
            //int mid = (left + right) / 2;
            int mid = left + (right - left)/2;
            if (target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
