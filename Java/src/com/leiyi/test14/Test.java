package com.leiyi.test14;

import java.util.HashSet;

/**
 * @author Leiyi548
 * @date 2021/12/31 10:50 上午
 */
public class Test {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs2 = {"ab","a"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs2)); }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans;
        ans = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < ans.length(); j++) {
                if (ans.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
            if ("".equals(ans)){
                return ans;
            }
        }
        return ans;
    }
}
