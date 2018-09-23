package com.syh.common.aop;

import com.syh.annotion.LogApi;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogAspject {

    public static final Logger logger = LoggerFactory.getLogger(LogAspject.class);
    public SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    @Pointcut(value = "@annotation(com.syh.annotion.LogApi)")
    private void pointCute(){}

    @Before(value = "pointCute() && @annotation(api)")
    public void beforeTodo(JoinPoint point, LogApi api){
        String operate = api.api();
        logger.debug("当前操作："+operate);
        logger.debug("起始时间："+format.format(new Date()));
    }

    @After(value = "pointCute() && @annotation(api)")
    public void afterTodo(JoinPoint point, LogApi api){
        String operate = api.api();
        logger.debug("结束操作："+operate);
        logger.debug("结束时间："+format.format(new Date()));
    }

    @AfterReturning(value = "pointCute() && @annotation(api)", returning = "object")
    public void afterReturnTodo(JoinPoint point, LogApi api, Object object){
        Signature signature = point.getSignature();
        Class type = signature.getDeclaringType();
        logger.debug("操作：" + api.api() +"执行结束,返回值为："+object +"执行的类为：" +type.getName());

    }
}
