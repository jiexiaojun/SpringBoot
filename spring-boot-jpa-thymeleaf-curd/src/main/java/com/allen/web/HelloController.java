package com.allen.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	// http://localhost:8080/hello?name=LL
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/test")
	// http://localhost:8080/test
	public String test() {
		createException();
		return "这里制造异常  但是被全局异常 GlobalExceptionHandler类处理 将错误信息 返回给前端了";
	}

	@SuppressWarnings("unused")
	private void createException() {
		int i = 5 / 0;
	}
}
