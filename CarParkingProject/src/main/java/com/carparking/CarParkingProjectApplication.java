package com.carparking;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.carparking.entities.UserRepository;
import com.carparking.entities.Users;


@SpringBootApplication
public class CarParkingProjectApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(CarParkingProjectApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		Users users = new Users(1, "Dhairya", "Agrawal", "dhairya44", "ReaPeR", "ReaPeR", "07 Kishan Duplex", "dhairya.agrawal@gmail.com", "9974253776", "GJ2017");
		
		List<Users> user = userRepository.findByEmail(users.getEmail());
		if(user.isEmpty())
			userRepository.save(users);
		
		System.out.println(user);
		
	}

}	
