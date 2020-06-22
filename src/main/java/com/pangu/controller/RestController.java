package com.pangu.controller;

import com.alibaba.fastjson.JSONObject;
import com.pangu.entity.RestEntity;
import com.pangu.http.request.HttpClient;
import com.pangu.http.response.RestResult;
import com.pangu.monitor.rest.RestCostTime;
import com.pangu.monitor.rest.RestInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-12 18:27
 * @desc:
 */
@org.springframework.web.bind.annotation.RestController
@RestInfo
public class RestController {

    @Resource
    private RestEntity restEntity;

    @RequestMapping(value = "/test")
    public RestResult<JSONObject> restInfo(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("extra",restEntity.getExtra());
        return RestResult.successResult(jsonObject);
    }

    @RequestMapping(value = "/kefu")
    public RestResult<String> kefu() throws Exception {
        String url = "http://10.157.136.234:8000/gulfstream/themis/v2/serviceControl/getKefuCompensateJudge";
        JSONObject object = new JSONObject();
        object.put("order_id","87969391989219");
        object.put("district","03035");
        object.put("requester_type",2);
        object.put("lang","ex-MX");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "appliction/json");
        String object1 = HttpClient.doPostJsonHttp(url,object, httpHeaders, 3000,3000);
        return RestResult.successResult(object1);
    }


}
