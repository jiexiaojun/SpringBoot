package com.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

	/**
	 * 
	 * @方法描述：跳转hi页面
	 * @创建人：jie.xiaojun
	 * @创建时间：2018年8月30日 上午11:41:54
	 * @修改人：jie.xiaojun
	 * @修改时间：2018年8月30日 上午11:41:54
	 * @修改内容：
	 * @param locale
	 * @param model
	 * @return	
	 * @version 1.0
	 */
	@RequestMapping("/hi")
	public String hello(Locale locale, Model model) {
		model.addAttribute("greeting", "Hi 哈哈哈哈哈哈哈哈哈哈哈!");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("currentTime", formattedDate);
		return "web/hi";
	}

	/**
	 * 
	 * @方法描述：跳转index页面
	 * @创建人：jie.xiaojun
	 * @创建时间：2018年8月30日 上午11:42:23
	 * @修改人：jie.xiaojun
	 * @修改时间：2018年8月30日 上午11:42:23
	 * @修改内容：
	 * @param locale
	 * @param model
	 * @return	
	 * @version 1.0
	 */
	@RequestMapping("/index")
	public String index(Locale locale, Model model) {
		model.addAttribute("greeting", "欢迎来到召唤师峡谷");
		return "web/index";
	}

}
