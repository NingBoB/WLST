package com.dmm.middleware.whitelist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mean
 * @date 2025/1/11 15:42
 * @description 白名单配置
 */
// @Component      // 注意，若采用这种方式，需要确保启动类可以扫到该目录，所以这种方式不推荐在starter项目中使用
@ConfigurationProperties(prefix = "dmm.whitelist", ignoreInvalidFields = true)
public class WhiteListProperties {
	private String users;

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}
}
