package com.pangu.Thread;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-24 13:35
 * @desc:
 */
public class ThreadUtil implements Runnable {

    private Thread thread;
//    public ThreadUtil(Thread thread){
//        this.thread = thread;
//    }
    @Override
    public void run() {
//        System.out.println(thread.getId()+"====="+thread.getName());
        System.out.println("hello world");
    }

    public static void main(String[] args){
        Thread thread = new Thread();
        thread.start();
        ThreadUtil threadUtil = new ThreadUtil();
        threadUtil.run();
    }



}
