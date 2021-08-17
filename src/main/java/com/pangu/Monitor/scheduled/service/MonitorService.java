package com.pangu.Monitor.scheduled.service;


import com.pangu.Monitor.scheduled.Entity.MonitorEntity;

/**
 * @author:liuzhaolu
 * @createTime: 2020-06-26 16:40
 * @desc: 监控服务类
 */
public interface MonitorService {
    /**
     * 开始监控
     * @param monitorEntity
     * @throws Exception
     */
    void start(MonitorEntity monitorEntity) throws Exception;
}
