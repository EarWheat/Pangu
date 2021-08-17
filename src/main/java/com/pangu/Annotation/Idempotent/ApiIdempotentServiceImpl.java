package com.pangu.Annotation.Idempotent;

import com.alibaba.fastjson.JSONObject;
import com.pangu.Redis.RedisUtil;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/23 下午7:32
 * @desc 幂等校验类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ApiIdempotentServiceImpl implements ApiIdempotentService{
    @Override
    public boolean checkRequestIdempotent(HttpServletRequest httpServletRequest) {
        /**
         * 此处只校验了Body部分，如果有需求有需要校验header的参数，也请加上
         */
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        System.out.println("========" + JSONObject.toJSONString(parameterMap));
        String requestParam = Base64.getEncoder().encodeToString(DigestUtils.md5(JSONObject.toJSONString(parameterMap)));
        return RedisUtil.exists(requestParam);
    }
}
