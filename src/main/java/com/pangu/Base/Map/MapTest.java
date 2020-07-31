package com.pangu.Base.Map;

import com.pangu.Base.String.Ticket;

import java.util.*;
import java.util.concurrent.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-30 11:15
 * @desc:Java基础Map类
 */
public class MapTest {
    private final static int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static int times = 1000;
    private static int a = 100;
    private static int b = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(times);
    private static CountDownLatch mainCountDownLatch = new CountDownLatch(times);
    private static int hashMapValue = 1;
    private static int hashTableValue = 1;
    private static int concurrentHashMapValue = 1;

    public static void main(String[] args) {
        HashMap<Object, Integer> hashMap = new HashMap<>();
        Hashtable<Object, Integer> hashtable = new Hashtable<>();
        TreeMap<Object, Integer> treeMap = new TreeMap<>();
        ConcurrentHashMap<Object, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        LinkedHashMap<Object, Integer> linkedHashMap = new LinkedHashMap<>();
//        // 验证有序性
//        for(int i = 0; i < 100; i++){
//            hashMap.put(String.valueOf(i),i);
//            linkedHashMap.put(String.valueOf(i),i);
//            treeMap.put(String.valueOf(i),i);
//        }
//        for(Map.Entry<Object, Integer> mapEntry : hashMap.entrySet()){
//            // 并非顺序展示
//            System.out.println("hashMap:" + mapEntry.getKey() + "----" + mapEntry.getValue());
//        }
//        for(Map.Entry<Object, Integer> mapEntry : linkedHashMap.entrySet()){
//            // 顺序展示
//            System.out.println("linkedHashMap:" + mapEntry.getKey() + "----" + mapEntry.getValue());
//        }
//        for(Map.Entry<Object, Integer> mapEntry : treeMap.entrySet()){
//            // 按照Key的升序列顺序展示
//            System.out.println("treeMap:" + mapEntry.getKey() + "----" + mapEntry.getValue());
//        }

        // 验证线程安全性
//        int carPoolSize = 200;
//        int maxThreadSize = 1000;
//        long keepAlive = 30;
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(carPoolSize,maxThreadSize,keepAlive, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1));
        hashMap.put("num",1);
        hashtable.put("num",1);
        concurrentHashMap.put("num",1);
//        for(int i = 0; i  < times; i++){
//            threadPoolExecutor.execute(()->{
//                try {
//                    countDownLatch.countDown();
//                    countDownLatch.await();
//                    Thread.sleep((long) (Math.random() % 100000));
//                    int hashMapTemp = hashMap.get("num");
//                    int hashTableTemp = hashtable.get("num");
//                    int concurrentHashMapTemp = concurrentHashMap.get("num");
//                    hashMap.put("num", hashMapTemp + 1);
//                    hashtable.put("num", hashTableTemp + 1);
//                    concurrentHashMap.put("num", concurrentHashMapTemp + 1);
//                    mainCountDownLatch.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }

        for(int i = 0; i < times; i++){
            new Thread(new Ticket()).start();
        }

//        for (int i = 0; i < times; i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
////                        countDownLatch.countDown();
////                        countDownLatch.await();
//                        while (true) {
//                            // 没有余票时，跳出循环
//                            if (a <= 0) {
//                                break;
//                            }
//                            b++;
//                            a--;
//                            System.out.println("显示出票信息：" + Thread.currentThread().getName()
//                                    + "抢到第" + b + "张票，剩余" + a + "张票");
//                        }
//
////                        hashMap.put("num", hashMap.get("num") + 1);
////                        hashtable.put("num", hashtable.get("num") + 1);
////                        concurrentHashMap.put("num", concurrentHashMap.get("num") + 1);
////                        synchronized (this){
////                            a++;
////                        }
////                        System.out.println(Thread.currentThread().getName() + "====执行完毕" );
//                        mainCountDownLatch.countDown();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
        try {
//            mainCountDownLatch.await();
            System.out.println(a);
            System.out.println("hashMap:" + hashMap.get("num"));
            System.out.println("hashtable:" + hashtable.get("num"));
            System.out.println("concurrentHashMap:" + concurrentHashMap.get("num"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
