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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        res.add(list);
        res.add(list);
        res.add(list);
        return res;
    }
}