package com.pangu.Base.String;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 21:25
 * @desc:
 */
public class StrBuffer implements Runnable{

    private StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void run() {
        stringBuffer.append("a");
        System.out.println(stringBuffer.length());
    }
}
