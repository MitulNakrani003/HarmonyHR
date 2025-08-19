package com.mandm.harmony_hr;

import com.mandm.harmony_hr.entities.Employee;
import com.mandm.harmony_hr.entities.Users;
import com.mandm.harmony_hr.models.Roles;
import com.mandm.harmony_hr.repositories.EmployeeRepository;
import com.mandm.harmony_hr.repositories.UsersRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
@EnableCaching
public class HarmonyHrApplication {
	public static void main(String[] args) {
		SpringApplication.run(HarmonyHrApplication.class, args);
	}

}
