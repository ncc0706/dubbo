package com.xlinyu.api;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xlinyu.user.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private IUserService userService;
	
	@RequestMapping(value = "/user/{message}", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello(@PathVariable("message") String message){
		logger.info("message: " + message);
		String greeting = userService.sayHello(message);
		return new ResponseEntity<String>(greeting, HttpStatus.OK);
	}
	
}
