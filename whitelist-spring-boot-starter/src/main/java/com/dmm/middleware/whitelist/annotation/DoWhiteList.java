package com.dmm.middleware.whitelist.annotation;

import java.lang.annotation.*;

/**
 * @author Mean
 * @date 2025/1/11 15:41
 * @description 白名单注解
 */
@Retention(RetentionPolicy.RUNTIME)     // 元注解---注解的注解，配置为在运行时生效
@Target(ElementType.METHOD)     // 元注解---注解的作用目标，配置为方法
@Inherited
public @interface DoWhiteList {
	// 接口入参提取的信息,设定需要校验的参数
	String key() default "";
	// 拦截后的返回内容
	String returnJson() default "";
}
