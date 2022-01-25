package com.leiyi.test38;

/**
 * @author Leiyi548
 * @date 2022/1/22 11:12 上午
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(2));
    }
}

class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0, pos = 0;
            while(pos < str.length()){
                while(pos<str.length() && str.charAt(pos) == str.charAt(start)){
                    pos++;
                }
                sb.append(Integer.toString(pos-start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }
}
