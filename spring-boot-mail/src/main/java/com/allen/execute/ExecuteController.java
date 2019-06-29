/**
 * @项目名称：spring-boot-mail
 * @文件名称：ExecuteController.java
 * @所属包名：com.allen.execute
 * @创建时间：2019年6月29日下午3:01:43
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.execute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.allen.service.impl.MailServiceImpl;

/**
 * @类名称：ExecuteController
 * @类描述：TODO
 * @创建人：allen
 * @创建时间：2019年6月29日 下午3:01:43
 */
@RestController
public class ExecuteController {

	private MailServiceImpl mailServiceImpl;

	@Autowired
	public ExecuteController(MailServiceImpl mailServiceImpl) {
		this.mailServiceImpl = mailServiceImpl;
	}

	@RequestMapping("/send")
	// http://localhost:8080/send
	public String send() {
		mailServiceImpl.sendSimpleMail("it010@slpcb.net", "测试", "测试");
		return "发送成功";
	}


}

