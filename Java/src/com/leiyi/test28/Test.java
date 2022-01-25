package com.leiyi.test28;

/**
 * @author Leiyi548
 * @date 2022/1/13 3:19 下午
 */
public class Test {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(haystack.substring(0, haystack.length()));
        System.out.println(new Solution().strStr(haystack, needle));
    }

    public static void test() {
        String s = "hello,world";
        String word = "first,second,third";
        System.out.println(s.indexOf('e'));
        System.out.println(word.indexOf("sec"));
    }
}

class Solution {
//        public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i < n-m; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i+j)!=needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
