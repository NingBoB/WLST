package com.dmm.middleware.whitelist.config;

import com.dmm.middleware.whitelist.DoJoinPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mean
 * @date 2025/1/11 15:41
 * @description 白名单自动配置
 */
@Configuration
@ConditionalOnClass(WhiteListProperties.class)  // 当前路径下存在WhiteListProperties类时，才会加载这个配置类
@EnableConfigurationProperties(WhiteListProperties.class) // 开启配置属性
public class WhiteListAutoConfigure {

	@Bean
	@ConditionalOnMissingBean
	public String whiteListConfig(WhiteListProperties properties) {
		return properties.getUsers();
	}

	// 另一种切面的引入方式
	@Bean
	@ConditionalOnMissingBean
	public DoJoinPoint point(){
		return new DoJoinPoint();
	}

}
