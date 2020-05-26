package com.pangu.annotationTest;

import com.pangu.monitor.rest.RestCostTime;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-26 18:14
 * @desc:
 */
public class RestCostTimeTest {

    @RestCostTime
    @org.junit.jupiter.api.Test
    void testRestCostTime() throws InterruptedException {
        System.out.println("hello");
        Thread.sleep(1000);
        System.out.println("end");
    }
}
