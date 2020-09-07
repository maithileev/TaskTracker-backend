package com.webapi.tasktracker.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.tasktracker.model.AuthenticationModel;

@RestController
@CrossOrigin(origins = "*")
public class BasicAuthenticationController {

	@GetMapping("/BasicAuthentication")
	public AuthenticationModel getAuthMessage() {
		return new AuthenticationModel("You are autheticated");
	}
}
