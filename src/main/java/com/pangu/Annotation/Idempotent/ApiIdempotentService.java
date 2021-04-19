package com.pangu.Annotation.Idempotent;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/23 下午7:32
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface ApiIdempotentService {
    boolean checkRequestIdempotent(HttpServletRequest httpServletRequest);
}
