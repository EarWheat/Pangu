package com.pangu.log;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-20 18:15
 * @desc:
 */
public class LogUtils {
    static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    /**
     * info log
     * @param str
     */

    public void error(String str){
        logger.error(str);
    }

    public void warn(String str){logger.warn(str);}
}
