package com.leiyi.test20;

import java.util.*;

/**
 * @author Leiyi548
 * @date 2022/1/6 11:02 上午
 */
public class Test {
    public static void main(String[] args) {
        String s = "()[]{";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }

    public static void test() {
        Deque<Character> stack = new LinkedList<>();
        String s = "word";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            stack.push(ch);
        }
        System.out.println(stack.peek());
        System.out.println(stack.getFirst());
        System.out.println(stack.getLast());
        System.out.println(stack.size());
        System.out.println(stack.contains('o'));
        System.out.println(stack.contains('k'));
    }
}

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Deque<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
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
