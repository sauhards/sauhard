package com.login.loginsignup.service;


import com.login.loginsignup.model.User;
import com.login.loginsignup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class MainService {

	@Autowired
	PasswordEncoderService passwordEncoderService;

	@Autowired
	UserRepository userRepository;

	public String login(String id, String password) /*throws UsernameNotFoundException*/ {

//		String hashedPassword = passwordEncoderService.getEncodedPassword(password);

		Optional<User> user = userRepository.findById(id);

		System.out.println(user);

		if (user.get() == null){
//			throw new UsernameNotFoundException("id is not correct!");
			return "no user found!";
		}

//		 todo hashing logic

		System.out.println(user.get().getPassword());
//		System.out.println(hashedPassword);
		if(user.get().getPassword().equals(password)){
			return "Successful login";
		}
		else{
			return "wrong user name or password!";
		}

	}

	public Object signup(User user){



//		 id = email id logic


//		 mongodb create user
//		user.setPassword(passwordEncoderService.getEncodedPassword(user.getPassword()));
		return userRepository.save(user);

	}

}


// mysql -h remotemysql.com -P 3306 -u 8enEpCnxlo -p