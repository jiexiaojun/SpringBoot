package com.web.controller;

import java.util.Locale;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @类名称：HelloController
 * @类描述：TODO
 * @创建人：jie.xiaojun
 * @创建时间：2018年8月30日 上午11:34:40
 */
@RestController
// @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Locale locale, Model model) {
		return "hello spring-boot-web";
	}

	@RequestMapping("/uid")
	String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}

}
