package com.pangu;

import com.alibaba.fastjson.JSONObject;
import com.pangu.entity.ErrorCode;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-19 16:05
 * @desc:http response
 */
public class Pangu {

    // 成功默认返回
    public String success(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errno",ErrorCode.SUCCESS.getCode());
        jsonObject.put("data",ErrorCode.SUCCESS.getInfo());
        return jsonObject.toJSONString();
    }

    // 失败默认返回
    public String error(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errno",ErrorCode.ERROR.getCode());
        jsonObject.put("data",ErrorCode.ERROR.getInfo());
        return jsonObject.toJSONString();
    }

    public String success(Object object){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errno",ErrorCode.SUCCESS.getCode());
        jsonObject.put("data",object.toString());
        return jsonObject.toJSONString();
    }
}
