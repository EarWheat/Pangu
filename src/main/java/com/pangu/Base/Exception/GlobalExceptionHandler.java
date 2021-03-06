package com.pangu.Base.Exception;


import com.pangu.Http.response.RestResult;
import com.pangu.Http.response.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/11 下午8:00
 * @desc 全局异常处理类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResult exceptionHandler() {
//        LOGGER.error("服务器异常", ex);
        return RestResult.failResult(ResultEnum.EXCEPTION);
    }
}
