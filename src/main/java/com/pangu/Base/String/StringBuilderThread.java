package com.pangu.Base.String;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 19:12
 * @desc: 测试StringBuilder线程不安全
 */
public class StringBuilderThread implements Runnable {
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void run() {
        while (stringBuilder.length() < 100){
            stringBuilder.append("a");
            System.out.println(Thread.currentThread().getName() + "======" + stringBuilder.length() + "=======" + stringBuilder.toString());
            try {
                Thread.sleep(500);// 模拟网络延时
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
