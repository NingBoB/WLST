package com.dmm.middleware.whitelist;

import com.alibaba.fastjson2.JSONObject;
import com.dmm.middleware.whitelist.annotation.DoWhiteList;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author Mean
 * @date 2025/1/11 15:42
 * @description 白名单切入点
 */
@Aspect
@Component
public class DoJoinPoint {
	private Logger logger = LoggerFactory.getLogger(DoJoinPoint.class);

	@Resource
	private String whiteListConfig;

	@Pointcut("@annotation(com.dmm.middleware.whitelist.annotation.DoWhiteList)")
	public void aopPoint() {
	}

	@Around("aopPoint()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 获取方法上的注解信息
		Method method = getMethod(joinPoint);
		DoWhiteList whiteList = method.getAnnotation(DoWhiteList.class);

		// 获取注解配置字段值
		String keyValue = getFiledValue(whiteList.key(), joinPoint.getArgs());
		logger.info("middleware whitelist handler method：{} value：{}", method.getName(), keyValue);
		if (null == keyValue || "".equals(keyValue)) return joinPoint.proceed();

		String[] spilt = whiteListConfig.split(",");

		// 白名单过滤
		for (String s : spilt) {
			if (s.equals(keyValue)) {
				return joinPoint.proceed();
			}
		}

		// 拦截
		return returnObject(whiteList, method);
	}

	// 获取方法
	private Method getMethod(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
		Signature sig = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) sig;
		return joinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
	}

	// 获取注解配置字段值
	private String getFiledValue(String field, Object[] args) {
		String filedValue = null;
		for (Object arg : args) {
			try {
				if (null == filedValue || "".equals(filedValue)) {
					filedValue = BeanUtils.getProperty(arg, field);
				} else {
					break;
				}
			} catch (Exception e) {
				if (args.length == 1) {
					return args[0].toString();
				}
			}
		}
		return filedValue;
	}

	// 返回对象
	private Object returnObject(DoWhiteList whiteList, Method method) throws IllegalAccessException, InstantiationException {
		Class<?> returnType = method.getReturnType();
		String returnJson = whiteList.returnJson();
		if ("".equals(returnJson)) {
			return returnType.newInstance();
		}
		return JSONObject.parseObject(returnJson, returnType);
	}
}
