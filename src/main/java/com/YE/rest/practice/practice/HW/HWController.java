package com.YE.rest.practice.practice.HW;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWController {
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping(path="/hello",method=RequestMethod.GET)
	public String helloworld()
	{
		return "Hello World";
	}
	@GetMapping(path="/hello-bean")
	public HWBean helloworldbean()
	{
		return new HWBean("Hello World");
	}
	@GetMapping(path="/hello-bean/{name}")
	public HWBean helloworldbean(@PathVariable String name)
	{
		return new HWBean("Hello World"+name);
	}
	@GetMapping(path="/hweighteen")
	public String helloWorldI18n(@RequestHeader(name="Accept-Language",required=false) Locale locale)
	{
		return messageSource.getMessage("good.morning.message", null,locale);
	}
	
	
}
