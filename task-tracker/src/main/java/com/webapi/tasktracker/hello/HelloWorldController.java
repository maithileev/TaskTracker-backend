package com.webapi.tasktracker.hello;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {
	
	@GetMapping(path = "/helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	@GetMapping(path = "/helloworldbean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeErrorException(null, "Something wrong happened");
		return new HelloWorldBean("Hello World new");
	}
	
	@GetMapping(path = "/helloworldbean/path/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
}
