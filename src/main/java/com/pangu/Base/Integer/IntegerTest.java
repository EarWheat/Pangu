package com.pangu.Base.Integer;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 14:48
 * @desc: 测试自动装箱
 */
public class IntegerTest {
    public static void main(String[] args) {
        int a = 12;    // 基本类型，存值，默认为0
        int b = 12;
        System.out.println(a == b);   //

        a = 129;
        b = 129;
        System.out.println(a == b);

        Integer c = 12;   // 对象，内存中有地址，默认为null
        Integer d = 12;
        System.out.println(c == d);

        c = 129;
        d = 129;
        System.out.println(c == d);



        int e = 12;
        Integer f = 12;
        System.out.println(e == f);

        e = 129;
        f = 129;
        System.out.println(e == f);

        Integer num1;
        Integer num2;
        for (int i = 0; i < 150; i++) {
            num1 = i;
            num2 = i;
            System.out.println(i + " " + (num1 == num2));
        }
    }
}
