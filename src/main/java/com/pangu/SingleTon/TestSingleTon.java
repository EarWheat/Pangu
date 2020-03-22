package com.pangu.SingleTon;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-22 13:59
 * @desc:
 */
public class TestSingleTon {
    public static void main(String[] args){
        int i = 10;
        SingleTon singleTon = SingleTon.getInstance();
        SingleTon.setNum(i);
        SingleTon singleTon1 = SingleTon.getInstance();
        System.out.println("--------SingleTon1");
        System.out.println(SingleTon.getNum());
        System.out.println("--------SingleTon++");
        SingleTon.setNum(SingleTon.getNum()+1);
        System.out.println(SingleTon.getNum());
    }
}
