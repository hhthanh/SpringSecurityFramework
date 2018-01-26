package dao;

import model.User;

public interface UserDAO {
	public User findByUsername(String username);
	public User findById(Integer id);
}
