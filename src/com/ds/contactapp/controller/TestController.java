package com.ds.contactapp.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/test/hello")
	public String helloWorld() {
		return "hello";//--> call to /WEB-INF/view/hello.jsp
		
	}
	@RequestMapping("/test/ajax_test")
	public String testPage() {
		return "test";//--> call to /WEB-INF/view/test.jsp
	}
	@RequestMapping("/test/get_time")
	@ResponseBody
	public String getServerTime() {
		System.out.println("get server time");
		Date d=new Date();
		return d.toString();//--> direct value,not a jsp page.Hence using @ResponseBody,o/p directly to outputstream
		
	}

}
