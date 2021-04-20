package com.study.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthInterceptor {
    /**
     * 是否验证请求头中的信息 true=验证 false=无需验证
     */
    boolean header() default true;

    /**
     * 方法说明
     */
    String remark() default "";
}