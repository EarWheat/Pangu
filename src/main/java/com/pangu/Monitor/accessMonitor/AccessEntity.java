package com.pangu.Monitor.accessMonitor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/17 5:13 下午
 * @desc access类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessEntity {
    /**
     * 请求uri
     */
    private String uri;
    /**
     * 请求url
     */
    private String url;
    /**
     * 来源ip
     */
    private String from;
    /**
     * 请求参数
     */
    private Object[] args;

    /**
     * 请求结果
     */
    private Object resp;

    /**
     * 请求耗时
     */
    private Long latency;
}
