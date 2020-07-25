package com.pangu.Base.String;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 15:15
 * @desc:Java基础,StringBuffer与StringBuilder
 */
public class StringTest {
    public static void main(String[] args) {
        // 线程安全
        Runnable bufferThread = new StringBufferThread();
        Thread bufferThread1 = new Thread(bufferThread,"buffer-1");
        Thread bufferThread2 = new Thread(bufferThread,"buffer-2");
        bufferThread1.start();
        bufferThread2.start();

//        // 线程不安全
//        Runnable builderThread = new StringBuilderThread();
//        Thread buildThread1 = new Thread(builderThread,"build-1");
//        Thread buildThread2 = new Thread(builderThread, "build-2");
//        buildThread1.start();
//        buildThread2.start();

//        Runnable ticket = new Ticket();
//        Thread jack = new Thread(ticket,"jack");
//        Thread maria = new Thread(ticket,"maria");
//        jack.start();
//        maria.start();
    }
}
