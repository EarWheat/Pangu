package com.pangu.http.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-26 10:18
 * @desc:
 */
public class RestResult<T> implements Serializable {
    private static final long serialVersionUID = 8731622331306688357L;

    @JSONField(name = "errno")
    private Integer errNo;
    @JSONField(name = "errMsg")
    private String errMsg;
    @JSONField(name = "data")
    private T data;

    public RestResult(int errNo, String errMsg, T data) {
        this.errNo = errNo;
        this.errMsg = errMsg;
        this.data = data;
    }

    public RestResult(){

    }

    public Integer getErrNo() {
        return errNo;
    }

    public void setErrNo(Integer errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static <T> RestResult<T> successResult(T data) {
        return new RestResult<>(0, "success", data);
    }

    public static <T> RestResult<T> failResult(int errNo, String errMsg, T data) {
        return new RestResult<>(errNo, errMsg, data);
    }
}
