package dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.UserDAO;
import model.User;

public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Override
	public User findByUsername(String username) {
		String sql = "SELECT username, password, email, fullname FROM user_data"
				+ " WHERE username = ?";
		String sql1 = "SELECT role FROM user_role WHERE username=?";
		User user = getJdbcTemplate().queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
		user.setRole(getJdbcTemplate().queryForList(sql1, new Object[]{username}, String.class));
		
		return user;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
