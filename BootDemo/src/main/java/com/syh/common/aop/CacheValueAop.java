package com.syh.common.aop;

import com.syh.annotion.CacheValue;
import com.syh.common.utils.RedisUtil;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CacheValueAop {
    public static final Logger logger = LoggerFactory.getLogger(CacheValue.class);
    public static final String POINT_CUT = "@annotation(com.syh.annotion.CacheValue)";

    @Pointcut("@annotation(com.syh.annotion.CacheValue)")
    public void cache(){}

    @Before(value = "@annotation(com.syh.annotion.CacheValue)")
    public void pointAfter(Joinpoint joinpoint) {


        AccessibleObject staticPart = joinpoint.getStaticPart();
        try {
            CacheValue annotation = staticPart.getAnnotation(CacheValue.class);
            int id = annotation.id();
            Class clazz = annotation.clazz();
            String method1 = annotation.method();
            logger.info("id:"+id+" clazz"+clazz.getName()+" method1:"+method1+" returnValue:");
            /*Method redisMethod = RedisUtil.class.getMethod(method1);
            logger.debug("存储的内容：id: " + clazz.getName() +" value: "+returnValue);
            redisMethod.invoke(clazz.getName()+id, returnValue);*/
        } finally {

        }
    }

}
