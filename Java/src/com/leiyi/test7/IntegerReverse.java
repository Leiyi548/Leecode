package com.leiyi.test7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2021/12/25 11:00 上午
 */
public class IntegerReverse {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int number = 0;
        System.out.println("请输入你要反转的数字");
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        in.close();
        Solution02 s2 = new Solution02();
        System.out.println(s2.reverse(number));
    }

}

class Solution {
    public int reverse(int x) {
        // 结果 (int)
        int ans = 0;
        // 判断是否是正数 (boolean)
        boolean positive = x > 0;
        // 如果x的绝对值小于10返回自身
        if (Math.abs(x) < 10) {
            return x;
        } else {
            ans = arrayListToNumber(reverseArrayList(numberToArrayList(Math.abs(x))));
            // Integer.MAX_VALUE   2147483647
            // -Integer.MIN_VALUE -2147483648
        }
        ans = positive ? ans : -ans;
        return ans;
    }

    public int arrayListToNumber(int[] arrayList) {
        int ans = 0;
        for (int i = 0; i <= arrayList.length - 1; i++) {
            ans = ans * 10 + arrayList[i];
        }
        return ans;
    }

    public int[] numberToArrayList(int num) {
        String strNumber = String.valueOf(num);
        int[] numberArrayList = new int[strNumber.length()];
        for (int i = 0; i < strNumber.length(); i++) {
            numberArrayList[i] = Integer.parseInt(String.valueOf(strNumber.charAt(i)));
            if (numberArrayList[i] == 0 && i == strNumber.length() - 1) {
                numberArrayList = Arrays.copyOf(numberArrayList, numberArrayList.length - 1);
            }
        }
        return numberArrayList;
    }

    public int[] reverseArrayList(int[] arrayList) {
        int arrayListLength = arrayList.length;
        int[] ans = new int[arrayListLength];
        for (int i = 0; i < arrayListLength; i++) {
            ans[i] = arrayList[arrayListLength - i - 1];
        }
        return ans;
    }

    public void printArrayList(int[] arrayList) {
        int arrayListLength = arrayList.length;
        for (int i = 0; i < arrayListLength; i++) {
            System.out.print(arrayList[i]);
        }
        System.out.println();
    }
}

class Solution02 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int lastNumber = x % 10;
            // -Integer.MIN_VALUE -2147483648
            // integer.MAX_VALUE   2147483647
            if (ans > 214748364 || (ans == 214748364 && lastNumber > 7)) {
                return 0;
            }
            if (ans < -214748364 || (ans == -214748364 && lastNumber < -8)) {
                return 0;
            }
            ans = ans * 10 + lastNumber;
            x = x / 10;
        }
        return ans;
    }
}
