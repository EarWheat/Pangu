package com.pangu.Rpc.rpcServer;

import com.pangu.Rpc.annotations.RpcServer;
import com.pangu.Rpc.api.HelloService;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/15 8:20 PM
 * @Version: 1.initial version; 2022/6/15 8:20 PM
 */
@RpcServer(serviceInterface = HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
}
