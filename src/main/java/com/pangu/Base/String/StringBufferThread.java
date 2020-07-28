package com.pangu.Base.String;

import java.util.concurrent.CountDownLatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-28 18:58
 * @desc:
 */
public class StringBufferThread implements Runnable {

    private StringBuffer stringBuffer;
    private CountDownLatch countDownLatch;

    public StringBufferThread(StringBuffer stringBuffer, CountDownLatch countDownLatch){
        super();
        this.stringBuffer = stringBuffer;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
//            System.out.println(Thread.currentThread().getName() + "-就绪");
            countDownLatch.countDown();
            countDownLatch.await();
            Thread.sleep((long) (Math.random() % 1000));
            stringBuffer.append("a");
//            System.out.println(Thread.currentThread().getName() + "-" + stringBuffer.length());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
