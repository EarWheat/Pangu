package com.pangu.time;

import java.util.Calendar;
import java.util.Date;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-20 18:11
 * @desc:
 */
public class TimeUtils {
    private static final Long Hour = 60L * 60L * 1000;

    /**获取当前时间的整点小时时间
     * @return
     */
    public Long getNextHourTime(){
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        Date date = ca.getTime();
        return date.getTime() + Hour;
    }

    /**
     * 获取当前毫秒级时间
     * @return
     */
    public Long getCurrTime(){
        Date date = new Date();
        return date.getTime();
    }
}
