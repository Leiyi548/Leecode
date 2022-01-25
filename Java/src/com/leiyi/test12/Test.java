package com.leiyi.test12;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2021/12/29 3:51 下午
 */
public class Test {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        System.out.println("Please input number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(solution02.intToRoman(number));
    }

    public void test01() {
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数");
            int number = scanner.nextInt();
            int thousands = number / 1000;
            int hundreds = number / 100 % 10;
            int ten = number / 10 % 10;
            int one = number % 10;
            System.out.print("thousands: " + thousands);
            System.out.print(" hundreds: " + hundreds);
            System.out.print(" ten: " + ten);
            System.out.print(" one: " + one);
        }
    }
    public void test02(){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(5,"e");
        System.out.println(map);
        // 通过索引获得value
        System.out.println(map.get(1));
        System.out.println(map.values());
        System.out.println("map size is " + map.size());
    }
}


class Solution {
    public String intToRoman(int num) {
        String ans = "";
        HashMap<Integer,String>map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int thousands = num / 1000;
        int hundreds = num / 100 % 10;
        int ten = num / 10 % 10;
        int one = num % 10;
        // 从整个哈希表中获得值 如果是58 十位正好是5 所以直接对应到L(50) 然后8 先减去5(V) 等于3(III)
        if (ten != 0){
            int tenNumber = ten * 10;
            if (map.containsKey(tenNumber)){
                ans += map.get(tenNumber) ;
            }
        }
        if (one !=0){
            if (map.containsKey(one)){
                ans += map.get(one);
            }
        }
        return ans;
    }
}

class Solution02{
    public String intToRoman(int num){
        StringBuffer ans = new StringBuffer();
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while(num >= value){
                ans.append(symbol);
                num -= value;
            }
        }
        return ans.toString();
    }
}
