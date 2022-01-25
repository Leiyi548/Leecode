package com.leiyi.test29;

/**
 * @author Leiyi548
 * @date 2022/1/13 4:23 下午
 */
public class Test {
    public static void main(String[] args) {
        int dividend = -1, divisor = -1;
        System.out.println(new Solution().divide(dividend, divisor));
    }
}

class Solution {
    public static final int MAX = Integer.MAX_VALUE;
    public static final int MIN = Integer.MIN_VALUE;

    public int divide(int dividend, int divisor) {
        // 溢出情况判断 (根据题目要求,如果除法结果溢出,就返回2^31-1(MAX)
        if (dividend == MIN && divisor == -1) {
            return MAX;
        }
        // 用来记录结果的符号
        int sign = -1;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            sign = 1;
        }
        // 将两个数转换成负数
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int ans = 0;

        // 因为是负数 所以是被除数小于除数
        while (dividend <= divisor) {
            int tmp = divisor, count = 1;
            // 这里注意不要写 tmp + tmp >= dividend 这样有可能会溢出(int)
            while (tmp >= dividend - tmp) {
                // 同时乘以2 count代表是当前(被除数已经乘了几次也就是tmp = divisor * count )
                tmp <<= 1;
                count <<= 1;
            }
            // 被除数减去tmp(也就是已经减去多少次的除数)然后把结果加到ans上
            dividend -= tmp;
            ans += count;
        }
        // 根据sign判断返回的正负
        return sign < 0 ? -ans : ans;
    }
}