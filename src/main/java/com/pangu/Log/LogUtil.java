package com.pangu.Log;

import com.pangu.springContext.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-25 19:02
 * @desc:日志辅助类
 */
@Component
public class LogUtil {
    public void info(String info){
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Environment environment = applicationContext.getEnvironment();
        System.out.println(applicationContext.toString());

    }
}
