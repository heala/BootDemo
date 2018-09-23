package com.syh.annotion;

import java.lang.annotation.*;

/**
 * 自定义redis缓存存储方式
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheValue {
    String value() default "";

    Class clazz();

    String method();

    int id();

}
