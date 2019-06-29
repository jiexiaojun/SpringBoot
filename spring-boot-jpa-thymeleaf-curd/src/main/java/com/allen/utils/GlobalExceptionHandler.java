package com.allen.utils;

/**
 * @项目名称：spring-boot-jpa-thymeleaf-curd
 * @文件名称：GlobalExceptionHandler.java
 * @所属包名：com.neo.utils
 * @创建时间：2018年9月22日上午8:34:04
 * @Copyright (c) 2018 SLPCB All Rights Reserved.
 */

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * 所有异常报错
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public String allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		exception.printStackTrace();
//		System.err.println("我报错了：" + exception.getLocalizedMessage());
//		System.err.println("我报错了：" + exception.getCause());
//		System.err.println("我报错了：" + exception.getSuppressed());
//		System.err.println("我报错了：" + exception.getMessage());
//		System.err.println("我报错了：" + exception.getStackTrace());

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		String msg = sw.toString();
		return msg;
	}

}
