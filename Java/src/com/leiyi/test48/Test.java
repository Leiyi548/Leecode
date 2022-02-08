package com.leiyi.test48;

/**
 * @author Leiyi548
 * @date 2022/2/7 7:38 下午
 */
public class Test {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    }
}

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // new matrix arr
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
            }
        }
    }
}
