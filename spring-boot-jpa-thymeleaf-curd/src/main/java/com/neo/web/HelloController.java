package com.neo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/test")
	public String test() {
		createException();
		return "我是正常的";
	}

	@SuppressWarnings("unused")
	private void createException() {
		int i = 5 / 0;
	}
}
