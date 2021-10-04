package com.pangu.Rpc.rpcServer;

import org.springframework.stereotype.Service;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 8:27 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Service
public class SayHelloServiceImpl implements SayHelloService{

    @Override
    public String say(String name){
        return "hello, " + name;
    }
}
