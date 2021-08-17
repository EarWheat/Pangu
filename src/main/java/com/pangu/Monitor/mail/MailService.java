package com.pangu.Monitor.mail;

/**
 * 警告邮件发送
 * @author liuzhaolu
 */
public interface MailService {
    /**
     * 发送文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String to, String subject, String content);

}
