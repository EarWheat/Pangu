package com.pangu.Rpc.rpcServer;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/4 3:19 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface SayHelloService extends RpcServer{

    String say(String name);
}
