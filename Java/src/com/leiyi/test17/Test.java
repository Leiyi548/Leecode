package com.leiyi.test17;

import java.util.*;

/**
 * @author Leiyi548
 * @date 2022/1/3 11:44 上午
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入数字");
        Scanner scanner = new Scanner(System.in);
        String digits;
        digits = scanner.nextLine();
        Solution solution = new Solution();
        solution.printList(solution.letterCombinations(digits));

    }
}

class Solution {
    private String[] lattersOnDigits = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        dfs(new StringBuilder(), digits);
        return ans;
    }

    private void dfs(StringBuilder path, String digits) {
        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }
        int currentNumber = digits.charAt(path.length()) - '0';
        String currentLetter = lattersOnDigits[currentNumber];
        for (char c : currentLetter.toCharArray()) {
            path.append(c);
            dfs(path, digits);
            // 删除最末尾的单词
            path.deleteCharAt(path.length() - 1);
        }
    }

    public void printList(List<String> list) {
        System.out.println("===begin print===");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("===end print===");
    }
}

