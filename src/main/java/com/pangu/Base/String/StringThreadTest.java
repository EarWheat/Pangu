package com.pangu.Base.String;

import java.util.concurrent.CountDownLatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 21:24
 * @desc: 多个线程调用一次。
 */
public class StringThreadTest {
//    public static void main(String[] args) {
//        Runnable strBuffer = new StrBuffer();
//        Runnable strBuilder = new StrBuilder();
//        // 线程安全
//        for(int i = 0; i < 100; i++){
//            Thread buffer = new Thread(strBuffer,"buffer-" + i);
//            buffer.start();
//        }
//        System.out.println("======================");
//        // 线程不安全
//        for(int i = 0; i < 100; i++){
//            Thread build = new Thread(strBuilder,"build-" + i);
//            build.start();
//        }
//    }

    public static void main(String[] args) {
        // 证明StringBuffer线程安全，StringBuilder线程不安全
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        CountDownLatch latch1 = new CountDownLatch(1000);
        CountDownLatch latch2 = new CountDownLatch(1000);

		/*StringBuffer不论运行多少次都是1000长度。
		StringBuilder绝大多数情况长度都会小于1000。
		StringBuffer线程安全，StringBuilder线程不安全得到证明。*/

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        stringBuilder.append(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch1.countDown();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {

                    try {
                        stringBuffer.append(1);

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch2.countDown();
                    }

                }
            }).start();
        }
        try {
            latch1.await();
            System.out.println(stringBuilder.length());
            latch2.await();
            System.out.println(stringBuffer.length());
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
