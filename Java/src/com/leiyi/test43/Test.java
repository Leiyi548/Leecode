package com.leiyi.test43;

/**
 * @author Leiyi548
 * @date 2022/1/26 2:45 下午
 */
public class Test {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String result = new Solution().multiply(num1, num2);
        System.out.println(result);
    }
}

class Solution {
    public String multiply(String num1, String num2) {

        // 获取两个String数组长度
        int n = num1.length(), m = num2.length();
        // 开辟空间来存放开辟的int数组
        int[] A = new int[n], B = new int[m];
        // 将两个数字倒着存放进int数组
        // 比如String num1 = "123" A = [3,2,1]
        for (int i = n - 1; i >= 0; i--) {
            A[n - 1 - i] = num1.charAt(i) - '0';
        } //反向存贮
        for (int i = m - 1; i >= 0; i--) {
            B[m - 1 - i] = num2.charAt(i) - '0';
        }

        // C是存放乘积结果的数组
        // 两个数字相乘比如 99 * 99 最多也就4位 因为100*100 = 10000(也就是5位)
        int[] C = new int[n + m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // String num1 = "123"  String num2 = "25"
                // A = [3,2,1] B = [5,2]
                //
                C[i + j] += A[i] * B[j];
            }
        }
        //存贮进位
        int t = 0;
        for (int i = 0; i < C.length; i++) {
            t += C[i];
            C[i] = t % 10;
            t /= 10;
        }
        int k = C.length - 1;
        while (k > 0 && C[k] == 0) {
            k--;
        }   //去除前导0
        StringBuilder sb = new StringBuilder();
        while (k >= 0) {
            sb.append((char) (C[k--] + '0'));
        } //反转
        return sb.toString();
    }
}

