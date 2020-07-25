package com.pangu.Base.String;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 15:20
 * @desc: 测试StringBuffer 线程安全
 */
public class StringBufferThread implements Runnable{

    private StringBuffer stringBuffer = new StringBuffer();

    @Override
    public void run() {
        // 同步锁方法
//        printStr();
        while (stringBuffer.length() < 100){
            stringBuffer.append("a");
            System.out.println(Thread.currentThread().getName() + "======" + stringBuffer.length() + "=======" + stringBuffer.toString());
        }
    }

    private synchronized void printStr(){
        while (stringBuffer.length() < 10) {
            stringBuffer.append("a");
            System.out.println(Thread.currentThread().getName() + "======" + stringBuffer.length() + "=======" + stringBuffer.toString());
        }
        System.out.println(Thread.currentThread().getName() + "======" + stringBuffer.length() + "=======" + stringBuffer.toString());
    }
//        if(stringBuffer.length() == 0){
//            stringBuffer.append(1);
//            System.out.println(Thread.currentThread().getName() + " is empty");
//        } else {
//            int a = Integer.parseInt(stringBuffer.toString());
//            while (a < 100){
//                 a = a + 1;
//                stringBuffer.append(a);
//                System.out.println(Thread.currentThread().getName() + "======" + (a));
//                try {
//                    Thread.sleep(500);// 模拟网络延时
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

}
