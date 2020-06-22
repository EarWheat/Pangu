package com.pangu.annotationTest;

import com.pangu.monitor.mail.IMailService;
import com.pangu.monitor.rest.RestCostTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * @author:liuzhaolujudgeQuizComment
 * @createTime: 2020-05-26 18:14
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestCostTimeTest {

    @Autowired
    private RestCostTimeService service;

    @Autowired
    private IMailService mailService;

    @Test
    @RestCostTime
    public void testRestCostTime() throws InterruptedException {
        System.out.println("hello");
        Thread.sleep(1000);
        System.out.println("end");
    }

    @Test
    public void test() throws InterruptedException {
        service.test(null);
    }

    @Test
    @RequestMapping("/achieve")
    @RestCostTime
    public void achieve(){
        System.out.println("方法执行-----------");
    }

    @Test
    public void sendmail() {
        mailService.sendSimpleMail("554725722@qq.com","主题：你好普通邮件","内容：第一封邮件");
    }




}
