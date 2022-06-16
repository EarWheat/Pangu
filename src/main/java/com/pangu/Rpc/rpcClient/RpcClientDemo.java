package com.pangu.Rpc.rpcClient;

import com.pangu.Rpc.annotations.RpcClient;
import com.pangu.Rpc.api.HelloService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 8:29 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Component
public class RpcClientDemo {

    @Resource
    private HelloService helloService;


    public void test(){
        System.out.println(helloService.sayHello("zelu"));
    }


}
