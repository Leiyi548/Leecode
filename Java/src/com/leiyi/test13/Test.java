package com.leiyi.test13;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2021/12/30 11:10 上午
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input String");
        String stringTest = scanner.nextLine();
        System.out.println(solution.romanToInt(stringTest));
    }
}

class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int i = 0;
        String firstString;
        String secondString;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("",0);
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        while (i < s.length()) {
            firstString = s.substring(i, i + 1);
            if (i != s.length() - 1) {
                secondString = s.substring(i + 1, i + 2);
            } else {
                secondString = "";
            }
            if (map.get(firstString) < map.get(secondString) && secondString != "") {
                String tmpStr = firstString + secondString;
                ans += map.get(tmpStr);
                i += 2;
            } else {
                ans += map.get(firstString);
                i++;
            }
        }
        return ans;
    }
}
