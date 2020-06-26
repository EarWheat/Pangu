package com.pangu.monitor.scheduled.service;

import com.pangu.monitor.scheduled.Entity.MonitorEntity;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-26 16:40
 * @desc: 监控服务类
 */
public interface IMonitorService{
    void startMonitor(MonitorEntity monitorEntity) throws Exception;
}
