package com.leiyi.test22;

import java.util.*;

/**
 * @author Leiyi548
 * @date 2022/1/8 3:42 下午
 */
public class Test {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.generateParenthesis(3));
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.generateParenthesis(3));
    }
}

class Solution02 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        if (open > n || close > open) {
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs(n, "", res);
        return res;
    }

    private void dfs(int n, String path, List<String> res) {
        if (path.length() == 2 * n) {
            if (isLegalBracket(path)) {
                res.add(path);
            }
            return;
        }
        dfs(n, path + "(", res);
        dfs(n, path + ")", res);
    }

    public boolean isLegalBracket(String s) {
        Deque<Character> stack = new LinkedList<>();
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !Objects.equals(stack.peek(), map.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
