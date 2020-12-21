package com.ruban.pangu.Base.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-18 18:26
 * @desc 启动自动装载Bean，启动时执行
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Component
public class StartBean {

    @Bean
    public void StartSomething(){
        Runnable runnable = new Runnable() {
            @lombok.SneakyThrows
            @Override
            public void run() {
                while (true){
                    System.out.println("Hello " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
