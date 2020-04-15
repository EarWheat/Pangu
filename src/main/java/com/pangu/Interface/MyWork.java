package com.pangu.Interface;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-03 21:38
 * @desc:
 */
public class MyWork implements Money {
    private long money;
    public MyWork(long money){
        this.money = money;
    }

    public long makeMoney(){
        return money + 100L;
    }
}
