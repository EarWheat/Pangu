package com.pangu.http.restful;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-26 10:18
 * @desc:
 */
public class RestFulResult<T> implements Serializable {
    private static final long serialVersionUID = 8731622331306688357L;

    @JSONField(name = "errno")
    private Integer errNo;
    @JSONField(name = "errMsg")
    private String errMsg;
    @JSONField(name = "data")
    private T data;

    public RestFulResult(int errNo, String errMsg, T data) {
        this.errNo = errNo;
        this.errMsg = errMsg;
        this.data = data;
    }

    public RestFulResult(){

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


    public static <T> RestFulResult<T> successResult(T data) {
        return new RestFulResult<>(0, "success", data);
    }

    public static <T> RestFulResult<T> failResult(int errNo, String errMsg, T data) {
        return new RestFulResult<>(errNo, errMsg, data);
    }
}
