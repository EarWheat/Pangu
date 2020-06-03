package com.pangu.annotationTest;

import com.pangu.monitor.rest.RestCostTime;
import org.springframework.stereotype.Service;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-02 20:17
 * @desc:
 */
@Service
public class RestCostTimeService {

    @RestCostTime
    public void test(String nullVal) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("rest");
        Thread.sleep(1000);
    }

}
