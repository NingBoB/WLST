package com.dmm.test.interfaces;

import com.dmm.middleware.whitelist.annotation.DoWhiteList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mean
 * @date 2025/1/11 16:47
 * @description UserController
 */
@RestController
// @Controller
// @RequestMapping("/api")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 通过：http://localhost:15333/api/queryUserInfo?userId=aaa
	 * 拦截：http://localhost:15333/api/queryUserInfo?userId=123
	 */
	@DoWhiteList(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
	@RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
	public UserInfo queryUserInfo(@RequestParam String userId) {
		logger.info("查询用户信息，userId：{}", userId);
		return new UserInfo("虫虫:" + userId, 19, "天津市东丽区万科赏溪苑14-0000");
	}
}
