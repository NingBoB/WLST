package com.dmm.middleware.whitelist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mean
 * @date 2025/1/11 15:42
 * @description 白名单配置
 */
// @Component
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
