package com.pangu.Util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/24 下午5:28
 * @desc https://blog.csdn.net/Summer_And_Opencv/article/details/104614320
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class MapperUtil implements InvocationHandler {


    private Object target;

    public MapperUtil(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }

}
