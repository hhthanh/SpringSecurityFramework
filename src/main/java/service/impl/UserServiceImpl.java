package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import dao.UserDAO;
import model.User;
import security.CustomUserDetail;
import service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public CustomUserDetail findByUserName(String username) {
		
		User user = userDAO.findByUsername(username);
		CustomUserDetail userDetail = new CustomUserDetail();
		userDetail.setUsername(username);
		userDetail.setPassword(user.getPassword());
		List<GrantedAuthority> authlist = new ArrayList<GrantedAuthority>();
		for(String s:user.getRole())
		{
			authlist.add(new SimpleGrantedAuthority(s));
		}
		userDetail.setAuthorities(authlist);
		return userDetail;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
