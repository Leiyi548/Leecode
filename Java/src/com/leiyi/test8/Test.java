package com.leiyi.test8;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Leiyi548
 * @date 2021/12/26 11:58 上午
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    public static void test03(){
       String str = " 4193 with words";
       str = str.trim();
       String pattern = "(\\d*)(.*)";
       Pattern r = Pattern.compile(pattern);
       Matcher m = r.matcher(str);
       if (m.find()){
           System.out.println(m.group(1));
       }else{
           System.out.println("NOT FOUND!!!");
       }

    }
    public static void testStringRegex() throws Exception {

        // split
        // 结果：[some, examples, of, regex, test]
        String query = "some examples of regex test";
        String[] parts = query.split(" ");
        printArrayList(parts);
        System.out.println("===FIRST===");
        System.out.println(Arrays.toString(parts));

        // matches 整个字符串是否匹配
        // 结果：false
        String regex = "regex";
        boolean isMatched = query.matches(regex);
        System.out.println("===SECOND===");
        System.out.println(isMatched);

        // replaceAll
        // 结果：some <REGEX> examples <REGEX> of <REGEX> regex <REGEX> test
        String replaceQuery = " <REGEX> ";
        String newQuery = query.replaceAll(" ", replaceQuery);
        System.out.println("===THIRD===");
        System.out.println(newQuery);
    }
    public static void test01() {

        String str = " word ";
        // trim 只能去掉 字符串 两端空格
        String new_str = str.trim();
        System.out.println(new_str);

        /**
         * 方法一
         * str.replace(" ", ""); 去掉所有空格，包括首尾、中间
         */

        String str2 = str.replace(" ", "");
        System.out.println(str2);

        /**
         *  方法二
         *  str.replaceAll(" ", ""); 去掉所有空格，包括首尾、中间
         */

        String str3 = str.replaceAll(" ", "");
        System.out.println(str3);

        /**
         *  方法三 : 正则表达式
         *  str.replaceAll("\\s*", "");
         *  可以替换大部分空白字符， 不限于空格
         *  \s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
         */
    }
    public static void test02(){
       String str = "abc";
       char c = str.charAt(0);
        System.out.println(c);
    }
    public static void printArrayList(String[] arrayList) {
        System.out.println("===printArrayList===");
        int arrayListLength = arrayList.length;
        for (int i = 0; i < arrayListLength; i++) {
            System.out.println(arrayList[i]);
        }
        System.out.println();
    }
}
