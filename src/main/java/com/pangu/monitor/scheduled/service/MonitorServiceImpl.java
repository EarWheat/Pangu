package com.pangu.monitor.scheduled.service;

import com.pangu.Constants;
import com.pangu.monitor.mail.IMailService;
import com.pangu.monitor.scheduled.Entity.MonitorEntity;
import com.pangu.redis.RedisPool;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-26 16:38
 * @desc: 日志监控服务类
 */
@Service
public class MonitorServiceImpl implements IMonitorService{

    private static LoggerFactory logger = new LoggerFactory(MonitorServiceImpl.class);
    @Resource
    private IMailService mailService;

    @Resource
    private RedisPool redisPool;

    @Value("${spring.monitor.master.email}")
    private String masterEmail;

    public void startMonitor(MonitorEntity monitor) throws Exception{
        // 监控的日志路径为空
        if(StringUtils.isBlank(monitor.getFilePath())){
            mailService.sendSimpleMail(masterEmail, Constants.RED_LEVEL_MONITOR + Constants.CONFIG_ERROR, "监控配置的日志路径为空");
        }

        try {
            File file = new File(monitor.getFilePath());
            if(file.length() > 0){

            }
        } catch (FileNotFoundException e){
            mailService.sendSimpleMail(masterEmail, Constants.RED_LEVEL_MONITOR + Constants.FILE_NOT_FOUND, "监控的日志不存在");
        } catch (Exception e){

        }
    }
}
