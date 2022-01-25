package com.leiyi.test8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Leiyi548
 * @date 2021/12/26 11:59 上午
 */
public class StringToInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution02 solution02 = new Solution02();
        String testStr = in.nextLine();
        int ans = 0;
        ans = solution02.myAtoi(testStr);
        System.out.println("Output: " + ans);
    }
}

class Solution02 {
    public int myAtoi(String s) {
        boolean positiveSign = true;
        int ans = 0;
        int i = 0;
        // 1.去除空格
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        // 2.判断符号
        if (s.charAt(i) == '-') {
            i++;
            positiveSign = false;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int lastNumber = s.charAt(i) - '0';
            // 判断是否会int溢出
            // Integer.MAX_VALUE   2147483647
            // Integer.MIN_VALUE  -2147483648
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && lastNumber > 7)) {
                return ans = positiveSign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + lastNumber;
            i++;
        }
        return ans = positiveSign ? ans : -ans;
    }
}

class Solution {
    public int myAtoi(String s) {
        /**
         * 1.去除掉字符串两端的空格
         * 2.判断第一个字符是正号还是负号
         * 3.如果有符号就将符号给去除掉
         * 4.再用正则表达式取出这个字符串里面的数字
         * 5.判断是否越界,越界就去边界值
         */
        int ans = 0;
        // positiveSign 判断是否是正号还是负号
        boolean positiveSign = true;
        // 去除字符串的空格
        s = s.trim();
        // 判断是否为空
        if (s.length() == 0) {
            return 0;
        }
        // 检查第一个字符
        char firstChar = s.charAt(0);
        if (firstChar == '-') {
            positiveSign = false;
            s = s.substring(1);
        } else if (firstChar == '+') {
            positiveSign = true;
            s = s.substring(1);
        }
        // 用正则表达式提取数字
        String pattern = "^[\\d]\\d*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        if (m.find()) {
            //截取匹配到的字符
            s = s.substring(m.start(), m.end());
        } else {
            return 0;
        }
        // 用异常来判断是否越界
        try {
            ans = Integer.parseInt(s);
            ans = positiveSign ? ans : -ans;
            return ans;
        } catch (Exception e) {
            return positiveSign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }
}
