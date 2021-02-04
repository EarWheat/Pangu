package com.pangu.HttpSession;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/2/4 下午6:16
 * @desc httpSession上下文
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Component
public class HttpSessionContext {
    private static Map<String, HttpSession> sessionContext = new HashMap<>();

    static void setHttpSession(String sessionId, HttpSession session){
        sessionContext.put(sessionId,session);
    }

    public static HttpSession getHttpSession(String sessionId){
        return sessionContext.get(sessionId);
    }

    static void destroyedHttpSession(String sessionId){
        sessionContext.remove(sessionId);
    }


}
