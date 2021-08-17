package com.pangu.Monitor.scheduled.service;

import com.pangu.Monitor.mail.MailService;
import com.pangu.Monitor.scheduled.Entity.MonitorEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author:liuzhaolu
 * @createTime: 2020-06-26 16:38
 * @desc: 日志监控服务类
 */
@Service
public class MonitorServiceImpl implements MonitorService{

    private static final Logger logger = LoggerFactory.getLogger(MonitorServiceImpl.class);
    @Resource
    private MailService mailService;


    @Value("${spring.monitor.master.email}")
    private String masterEmail;

    @Override
    public void start(MonitorEntity monitor) throws Exception{
        // 监控的日志路径为空
        if(StringUtils.isBlank(monitor.getFilePath())){
//            mailService.sendSimpleMail(masterEmail, Constants.RED_LEVEL_MONITOR + Constants.CONFIG_ERROR, "监控配置的日志路径为空");
        }

        try {
            File file = new File(monitor.getFilePath());
            if(file.length() > 0){

            }
        }  catch (Exception e){
//            mailService.sendSimpleMail(masterEmail, Constants.RED_LEVEL_MONITOR + Constants.FILE_NOT_FOUND, "监控的日志不存在");
        }
    }
}
