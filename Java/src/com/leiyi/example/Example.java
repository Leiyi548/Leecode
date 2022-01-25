package com.leiyi.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leiyi548
 * @date 2022/1/21 9:27 下午
 */
public class Example {
    public static void main(String[] args) {
        List<List<Integer>>res = new ArrayList();
        System.out.println(new Test().add());
    }
}

class Test {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> add() {
        Boolean []test = new Boolean[4];
        for (int i = 0; i < test.length; i++) {
            System.out.printf("test:" + test[i]);
        }
        return res;
    }
}