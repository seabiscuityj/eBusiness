package com.sean.ebusiness;
import java.sql.SQLException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 统一异常处理
 * @ControllerAdvice
 * 很多初学者可能都没有听说过这个注解，实际上，这是一个非常有用的注解。
 * 顾名思义，这是一个增强的 Controller。使用这个 Controller ，可以实现三个方面的功能：
 *
 * 		1. 全局异常处理
 * 		2. 全局数据绑定
 * 		3. 全局数据预处理
 * 灵活使用这三个功能，可以帮助我们简化很多工作.
 * 需要注意的是，这是 SpringMVC 提供的功能，在 Spring Boot 中可以直接使用
 */
@ControllerAdvice
public class GlobalExceptionHandleController {
	// @ExceptionHandler是用来指定异常的处理类型。
	// 如果这里指定为NullPointerException，则其他异常比如数组越界异常就不会进入到这个方法
	// 这里指定为Exception，也就是说所有的异常都进入这个方法处理
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		String message = "";
		//数据库异常
		if (e instanceof SQLException) {
			message = "数据库异常";
		} else if (e instanceof NoLoginException) {
			message = "未登录异常";
		} else {//未知异常
			message =  "未知异常";
		}
		model.addAttribute("mymessage",message);
		return "myError";
	}
}