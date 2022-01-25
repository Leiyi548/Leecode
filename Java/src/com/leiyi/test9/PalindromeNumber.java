package com.leiyi.test9;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2021/12/27 10:31 上午
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字");
        int number = scanner.nextInt();
        if(solution.isPalindrome(number)){
            System.out.println("是回文");
        }else{
            System.out.println("不是回文");
        }
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        /**
         * 1.将整数x转化成字符串1
         * 2.在判断是否是回文字符串(用左右指针)
         */
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int length = s.length();
        if (s.length() < 2) {
            return true;
        }
        int left = 0, right = length - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
