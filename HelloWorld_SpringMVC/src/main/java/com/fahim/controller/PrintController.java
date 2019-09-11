package com.fahim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrintController {

	@RequestMapping(path={"/"},method=RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping(path={"/printhello"},method=RequestMethod.GET)
	public String printHelloWorld() {
		return "helloWorld";
	}
	
}
