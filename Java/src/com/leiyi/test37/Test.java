package com.leiyi.test37;

/**
 * @author Leiyi548
 * @date 2022/1/21 7:57 下午
 */
public class Test {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution().solveSudoku(board);
        printBroad(board);
    }

    public static void printBroad(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.printf("[");
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf(String.valueOf(board[i][j]) + ",");
            }
            System.out.printf("],");
            System.out.println();
        }
    }
}

class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    /**
     * @param board 棋盘
     * @return 是否是正确的棋盘
     */
    private boolean solveSudokuHelper(char[][] board) {
        // 一个for循环遍历棋盘的行,一个for循环遍历棋盘的列
        // 一行一列确定下来之后,递归遍历这个位置放9个数字的可能性
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 不修改原始数字,直接跳过
                if (board[i][j] != '.') {
                    continue;
                }
                // 依次遍历9个字符 '1' 到 '9'
                for (char k = '1'; k <= '9'; k++) {
                    // 如果将这个字符放入棋盘是合法的就将这个字符放入棋盘内
                    if (isValidSudoku(i, j, k, board)) {
                        // 将这个字符放入进入棋盘
                        board[i][j] = k;
                        if (solveSudokuHelper(board)) {
                            return true;
                        }
                        // 说明后面的路走不通,所以前面放这个旗子会导致后面的路走不通
                        // 需要移除这个旗子
                        board[i][j] = '.';
                    }
                }
                // 9个数字都用完了,直接返回false
                // 因为一行一列确定下来了,这里尝试了9个数字都不行,说明这个棋盘找不到解决数独问题的解决方法
                // 那么直接返回 (这也是为什么没有终止条件也不会永远填不满棋盘而无限递归下去!)
                return false;
            }
        }
        // 说明棋盘没有问题
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度
     * 1.同行是否重复
     * 2.同列是否重复
     * 3.9宫格里是否重复
     *
     * @param row   需要判断的旗子在棋盘上的行号
     * @param col   需要判断的旗子在棋盘上的列号
     * @param val   需要判断的旗子在棋盘上的值
     * @param board 棋盘
     * @return 该旗子放下后在这个棋盘上是否合法
     */
    private boolean isValidSudoku(int row, int col, char val, char[][] board) {
        for (int i = 0; i < 9; i++) {
            // 出现重复数字违反第二条直接返回false
            if (board[row][i] == val) {
                return false;
            }
        }
        // 出现重复数字违反第一条直接返回false
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 判断第三个,九宫格内是否重复
        // 其中的 (row/3)代表的是第几个九宫格,而 (row/3)*3的目的是为了获得第几个九宫格一开始的索引
        int startRow = (row / 3) * 3;
        // 同上可得
        int startCol = (col / 3) * 3;
        // 判断现在9宫格内有重复的字母吗
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
