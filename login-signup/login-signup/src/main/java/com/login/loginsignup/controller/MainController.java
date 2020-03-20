package com.login.loginsignup.controller;


import com.login.loginsignup.model.User;
import com.login.loginsignup.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	MainService mainService;

	@GetMapping("/login")
	public String login(@RequestParam String id, @RequestParam String password)/* throws UsernameNotFoundException*/ {

		String resp =  mainService.login(id, password);

		return resp;
	}


	@GetMapping("/signup")
	public Object signup(@RequestBody User user){

		Object obj = mainService.signup(user);
		return obj;
	}

}
