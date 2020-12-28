package com.pangu.File;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-10 20:03
 * @desc 数据处理类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public abstract class DataProcess<T> {
    public abstract T process(byte[] bytes);
    public abstract Long length();
}
