package com.pangu;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pangu.http.restful.RestFulResult;
import com.pangu.response.Pangu;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-19 16:24
 * @desc:
 */
class PanguTest {

    @org.junit.jupiter.api.Test
    void testSuccess() {
        JSONObject object = JSON.parseObject("{\"errno\":0,\"errmsg\":\"SUCCESS\",\"data\":\"hello\"}");
        RestFulResult restFulResult1 = RestFulResult.successResult(object);
        System.out.println(JSONObject.toJSONString(restFulResult1));
        RestFulResult restFulResult2 = RestFulResult.failResult(10000,"ERROR","Test EXCEPTION");
        System.out.println(JSONObject.toJSONString(restFulResult2));
    }
}