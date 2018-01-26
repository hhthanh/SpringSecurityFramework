package security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import service.UserService;

public class CustomUserDetailService implements UserDetailsService  {
	private static final Logger logger = Logger.getLogger(CustomUserDetailService.class);

	@Autowired
	public UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Get infot user for security");
		CustomUserDetail user;
		user = userService.findByUserName(username);
		return new CustomUserDetail(user.getUsername(), user.getPassword(), user.getAuthorities());

	}
}
