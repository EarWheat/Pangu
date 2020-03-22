package com.pangu.SingleTon;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-22 14:07
 * @desc:
 */
public class TestSingleTon2 {
    public static void main(String[] args){
        SingleTon singleTon = SingleTon.getInstance();
        int i = singleTon.getNum();
        System.out.println(singleTon.getNum());
        singleTon.setNum(2);
        System.out.println(singleTon.getNum());
    }
}
