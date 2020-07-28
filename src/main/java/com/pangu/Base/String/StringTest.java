package com.pangu.Base.String;

import java.util.concurrent.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 15:15
 * @desc:Java基础,StringBuffer与StringBuilder
 *
 */
public class StringTest {

    private static StringBuffer stringBuffer = new StringBuffer();
    private static StringBuilder stringBuilder = new StringBuilder();
    private static CountDownLatch countDownLatch1 = new CountDownLatch(1000);
    private static CountDownLatch countDownLatch2 = new CountDownLatch(1000);

    public static void main(String[] args) throws InterruptedException {
//        // 同一个线程操作synchronized方法也是线程不安全的
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // 线程1重复执行append方法
//                while (stringBuffer.length() < 100) {
//                    stringBuffer.append("a");
//                    System.out.println(Thread.currentThread().getName() + "======" + stringBuffer.length());
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // 线程2重复执行append方法
//                while (stringBuffer.length() < 100) {
//                    stringBuffer.append("a");
//                    System.out.println(Thread.currentThread().getName() + "======" + stringBuffer.length());
//                }
//            }
//        });
//        thread1.start();
//        thread2.start();

        for(int i = 0; i < 1000; i++){
            new Thread(new StringBufferThread(stringBuffer,countDownLatch1)).start();
        }
        for(int i = 0; i < 1000; i++){
            new Thread(new StringBuilderThread(stringBuilder,countDownLatch2)).start();
        }
        countDownLatch1.await();
        countDownLatch2.await();
        System.out.println("-------------" + stringBuffer.length());
        System.out.println("+++++++++++++" + stringBuilder.length());
//        // 线程池模拟
//        int corePoolSize = 100;
//        int maximumPoolSize = 100;
//        long keepAliveTime = 10;
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maximumPoolSize, keepAliveTime, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>());
//        for(int i = 0; i < 100; i++){
//            threadPoolExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    // 每个线程只执行一次。
//                    stringBuffer.append("a");
//                    System.out.println(Thread.currentThread().getName() + "======" + stringBuffer.length());
//                }
//            });
//        }

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
