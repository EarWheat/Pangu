package com.pangu.Base.String;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 21:26
 * @desc:
 */
public class StrBuilder implements Runnable {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void run() {
        stringBuilder.append("a");
        System.out.println(stringBuilder.length());
    }
}
