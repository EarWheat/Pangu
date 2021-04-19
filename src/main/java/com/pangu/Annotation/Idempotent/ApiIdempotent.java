package com.pangu.Annotation.Idempotent;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/23 下午6:09
 * @desc Api请求幂等校验
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ApiIdempotent {
}
