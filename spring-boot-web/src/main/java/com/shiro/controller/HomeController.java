package com.shiro.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


	@RequestMapping({"/", "/index"})
	// 用于直接访问http://localhost:8080/index 页面跳转
	public String index() {
		System.out.println("进入index方法");
		return "/shiro/index";
	}


	@RequestMapping("/403")
	// 用于直接访问http://localhost:8080/403 页面跳转
	public String unauthorizedRole() {
		System.out.println("进入403方法");
		return "/shiro/403";
	}

	@RequestMapping("/login")
	// http://localhost:8080/login
	public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
		System.out.println("进入login方法");
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			}
			else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			}
			else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			}
			else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}
		map.put("msg", msg);
		// 此方法不处理登录成功,由shiro进行处理 登录失败停留在该页面并显示错误信息
		return "/shiro/login";
	}


}
