package com.pangu;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-19 16:24
 * @desc:
 */
class PanguTest {

    @org.junit.jupiter.api.Test
    void success() {
        Pangu httpResponse = new Pangu();
        System.out.println(httpResponse.success());
    }

    @org.junit.jupiter.api.Test
    void error() {
        Pangu httpResponse = new Pangu();
        System.out.println(httpResponse.error());
    }

    @org.junit.jupiter.api.Test
    void testSuccess() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("score",99);
        jsonObject.put("name","Math");
        Pangu httpResponse = new Pangu();
        System.out.println(httpResponse.success(jsonObject));
    }
}