package com.YE.rest.practice.practice.HW;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWController {
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
	
	
}
