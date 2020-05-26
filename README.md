# Pangu
Pangu SDK

## 简介
1、个人实战经验积累，打算编写一个盘古项目，开天劈地，提供基础功能SDK。希望做成SpringBoot的形式，通过一个注解引入盘古SDK，SDK集成基础功能，sl4j，MQ，Es等

## 使用说明
step1:maven导入SDK
```
<dependency>
   <groupId>com.pangu</groupId>
   <artifactId>pangu</artifactId>
   <version>1.0.0-RELEASE</version>
</dependency>
```

step2:引入注解

## 功能说明
1、RestfulResult
基于Restful格式返回的Json字符串。
使用示例：
```
JSONObject object = JSON.parseObject("{\"errno\":0,\"errmsg\":\"SUCCESS\",\"data\":\"hello\"}");
RestFulResult restFulResult1 = RestFulResult.successResult(object);
System.out.println(JSONObject.toJSONString(restFulResult1));
RestFulResult restFulResult2 = RestFulResult.failResult(10000,"ERROR","Test EXCEPTION");
System.out.println(JSONObject.toJSONString(restFulResult2));
```

