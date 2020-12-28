package com.pangu.annotationTest;

import com.alibaba.fastjson.JSONObject;
import com.pangu.Entity.RestEntity;
import com.pangu.Monitor.rest.RestInfo;
import com.pangu.Monitor.scheduled.annotation.Monitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-04 20:42
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@RestInfo
public class AnnotationTest {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationTest.class);


    @Resource
    private RestEntity restEntity;


    @Test
    @RequestMapping("/")
    @Monitor(pattern = "asqweqwe")
    public void welcome(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("extra",restEntity.getExtra());
        System.out.println(jsonObject.toJSONString());
        logger.info(jsonObject.toJSONString());
    }


}
