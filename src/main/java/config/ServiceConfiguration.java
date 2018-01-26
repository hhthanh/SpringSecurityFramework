package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import security.CustomUserDetailService;
import service.DatabaseService;
import service.UserService;
import service.impl.DatabaseServiceImpl;
import service.impl.UserServiceImpl;

@Configuration
public class ServiceConfiguration {

	@Bean
	public DatabaseService databaseService() {
		DatabaseService databaseService = new DatabaseServiceImpl();
		return databaseService;
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public CustomUserDetailService userDetailService() {
		return new CustomUserDetailService();
	}
}
