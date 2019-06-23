package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	// prehandle 1
	// prehandle 2
	// 요청 처리
	// postHandler 2
	// postHandler 1
	// 뷰 랜더링
	// afterCompletion 2
	// afterCompletion 1
	
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") Person person) {
		return "hello" + person.getName();
	}
	
	@GetMapping("/message")
	public String message(@RequestBody String body) {
		return body;
	}
	
	@GetMapping("/jsonMessage")
	public Person jsonMessage(@RequestBody Person person) {
		return person;
	}
	
}
