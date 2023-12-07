package com.baejimeel.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@RestController
public class HelloWorldController {

	@GetMapping(path = "/basicauth")
	public String basicAuthCheck() {
		return "success";
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World v2";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{username}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String username) {
		return new HelloWorldBean(String.format("Hello World, %s", username));
	}	
}
