package com.leiyi.test32;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Leiyi548
 * @date 2022/1/16 11:15 上午
 */
public class Test {
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(new Solution02().longestValidParentheses(s));
    }
}

class Solution02 {
    /**
     * 栈方法
     *
     * @param s 括号字符
     * @return 最长有效括号子串长度
     */
    public int longestValidParentheses(String s) {
        int ans = 0, n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        int position = -1;
        // 初始化第一个位置
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    ans = Math.max(ans,i - stack.peek());
                }
            }
        }
        return ans;
    }
}

class Solution {
    /**
     * 暴力法
     *
     * @param s 括号字符
     * @return 最长有效括号子串长度
     */
    public int longestValidParentheses(String s) {
        // 先遍历所有子串,然后判断是否是合法的括号,然后去最长的长度
        int ans = 0;
        int n = s.length();
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String subStr = s.substring(i, j + 1);
                if (subStr.length() < ans) {
                    continue;
                }
                if (isValidBracket(subStr)) {
                    ans = Math.max(ans, subStr.length());
                }
            }
        }
        return ans;
    }

    public boolean isValidBracket(String s) {
        Deque<Character> stack = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
