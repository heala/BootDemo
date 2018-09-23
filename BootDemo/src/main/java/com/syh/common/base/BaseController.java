package com.syh.common.base;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseController {

    HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    Object getSession (String key){
        return this.getSession().getAttribute(key);
    }

    void setSession(String key, Object value) {
        this.getSession().setAttribute(key, value);
    }

    HttpSession getSession(){
        return this.getHttpServletRequest().getSession(true);
    }

    String getIp(){
        String ip = this.getHttpServletRequest().getRemoteAddr();
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }

    Map<String, Object> getRequestJson() throws IOException {
        ServletInputStream inputStream = this.getHttpServletRequest().getInputStream();
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));

        Map<String, Object> returnValue = new HashMap<>();
        String content = "";
        while ((content = br.readLine())!=null) {
            sb.append(content);
        }
        JSONObject obj = JSONObject.parseObject(sb.toString());
        Set<String> keys = obj.keySet();
        for (String key : keys) {
            returnValue.put(key, obj.get(key));
        }
        return returnValue;
    }
}
