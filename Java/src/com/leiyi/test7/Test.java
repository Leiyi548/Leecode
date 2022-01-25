package com.leiyi.test7;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Leiyi548
 * @date 2021/12/25 11:20 上午
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int[] numberToArrayList(int num) {
        String strNumber = String.valueOf(num);
        int[] numberArrayList = new int[strNumber.length()];
        for (int i = 0; i < strNumber.length(); i++) {
            numberArrayList[i] = Integer.parseInt(String.valueOf(strNumber.charAt(i)));
            if (numberArrayList[i] == 0 && i == strNumber.length() - 1) {
                numberArrayList = Arrays.copyOf(numberArrayList, numberArrayList.length - 1);
                continue;
            }
        }
        return numberArrayList;
    }
    public static int[] reverseArrayList(int[] arrayList) {
        int arrayListLength = arrayList.length;
        int[] ans = new int[arrayListLength];
        for (int i = 0; i < arrayListLength; i++) {
            ans[i] = arrayList[arrayListLength - i - 1];
        }
        return ans;
    }
    public static int arrayListToNumber(int[] arrayList) {
        int ans = 0;
        for (int i = 0; i <= arrayList.length - 1; i++) {
            ans = ans * 10 + arrayList[i];
        }
        return ans;
    }
    public static void test2() {
        int[] arr = new int[3];
        arr = new int[]{1, 2, 3};
        System.out.println("===删除前===");
        printArrayList(arr);
        System.out.println("===删除后===");
        arr = Arrays.copyOf(arr, arr.length - 1);
        printArrayList(arr);
    }

    public static void printArrayList(int[] arrayList) {
        System.out.println("===printArrayList===");
        int arrayListLength = arrayList.length;
        for (int i = 0; i < arrayListLength; i++) {
            System.out.print(arrayList[i]);
        }
        System.out.println();
    }

    public static void test1() {
        int m = 123;
        String num = String.valueOf(m);
        int[] x = new int[num.length()];
        System.out.println("===Test begin===");
        System.out.println("String:" + num);
        for (int i = 0; i < num.length(); i++) {
            x[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] + " ");
        }
        if (x instanceof int[]) {
            System.out.println("This is a arrayList");
        }
        if (num instanceof String) {
            System.out.println("This is a String");
        }
        System.out.println("===Test over===");
    }
}
