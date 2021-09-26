package com.pangu.Rpc.rpcCenter;

import java.lang.reflect.Method;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/8 7:06 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface ServiceCenter {
    RemoteServiceInfo getRemoteService(Class<?> clazz, Method method);
}
