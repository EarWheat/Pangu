package com.pangu.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-20 18:15
 * @desc:
 */
@Component
public class LogUtils {
    static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public void info(String str){
        logger.info(str);
    }

    public void error(String str){
        logger.error(str);
    }

    public void warn(String str){logger.warn(str);}
}
