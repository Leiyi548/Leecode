package com.leiyi.test12;

/**
 * @author Leiyi548
 * @date 2021/12/29 8:09 下午
 */
public class LearnStringBuffer {
    public static void main(String[] args) {
        StringBuffer StringBufferTest = new StringBuffer("java");
        String StringAdd = "abcd";
        System.out.println(StringBufferTest);
        System.out.println("===Append===");
        StringBufferTest.append(StringAdd);
        System.out.println(StringBufferTest);
        System.out.println("===Insert===");
        StringBufferTest.insert(0,"one");
        System.out.println(StringBufferTest);
        System.out.println(StringBufferTest.deleteCharAt(0));
    }
}
