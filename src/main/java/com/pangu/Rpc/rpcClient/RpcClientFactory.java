package com.pangu.Rpc.rpcClient;

import com.pangu.Rpc.api.HelloService;
import com.pangu.Rpc.rpcServer.HelloServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/15 8:34 PM
 * @Version: 1.initial version; 2022/6/15 8:34 PM
 */
@Configuration
public class RpcClientFactory {

    @Bean
    public HelloService getHelloServiceRpc(){
        return new HelloServiceImpl();
    }
}
