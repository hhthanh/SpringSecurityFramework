package service;

import model.User;
import security.CustomUserDetail;

public interface UserService {
	public CustomUserDetail findByUserName(String username);
	public User findById(Integer id);
}
