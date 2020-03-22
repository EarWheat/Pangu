package com.pangu.SingleTon;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-22 13:49
 * @desc:
 */
public class SingleTon {
    // 静态实例
    private static SingleTon instance;
    private static int num;

    // 私有构造方法
    private SingleTon() {

    }

    //
    public static synchronized SingleTon getInstance(){
        if(instance == null){
            synchronized (SingleTon.class){
                return new SingleTon();
            }
        }
        return instance;
    }

    public static void setInstance(SingleTon instance) {
        SingleTon.instance = instance;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        SingleTon.num = num;
    }
}
