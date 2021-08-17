package com.pangu.Monitor.scheduled.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:liuzhaolu
 * @createTime: 2020-06-23 20:03
 * @desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorEntity {
    /**
     * 文件路径
     */
    private String filePath;
    // 正则表达式
    private String expression;
    // String
    private String info;
    // level 报警等级
    private String level;
    // 是否报警
    private boolean isWarn;
    // 报警标题
    private String title;
    // 报警内容
    private String content;
}
