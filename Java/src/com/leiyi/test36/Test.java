package com.leiyi.test36;

/**
 * @author Leiyi548
 * @date 2022/1/20 12:38 下午
 */
public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        char c = '9';
        int num = c - '0' - 1;
        System.out.println(num);
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //  rows数组 记录每一行的每个数字的出现数字
        // 例如: rows[0][1] = 2; 代表在第一行,数字2出现的次数为2,[数组是从0开始的]
        int [][]rows = new int[9][9];
        //  cols数组 记录每一列的每个数字的出现数字
        // 例如: rows[0][1] = 2; 代表在第一列,数字2出现的次数为2,[数组是从0开始的]
        int [][]cols = new int[9][9];
        // smallBox三维数组,其中是smallBox[i][j][index] 代表的是第i+1行第j+1个小数独 index的次数
        int [][][]smallBox = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.'){
                    int index = ch - '0' -1;
                    rows[i][index]++;
                    cols[j][index]++;
                    smallBox[i/3][j/3][index]++;
                    if (rows[i][index] > 1 || cols[j][index] > 1 || smallBox[i/3][j/3][index] > 1){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
