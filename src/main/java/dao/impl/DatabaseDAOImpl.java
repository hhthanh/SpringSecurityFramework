package dao.impl;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.DatabaseDAO;

public class DatabaseDAOImpl extends JdbcDaoSupport implements DatabaseDAO {

	Logger logger = LogManager.getLogger(this.getClass());
	ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
	@Override
	public boolean initDatabase() {
		logger.info("Initial Database!");
		try {
			rdp.addScripts(
					new ClassPathResource("init_database.sql"), 
					new ClassPathResource("user_login_data.sql"),
					new ClassPathResource("user_data_data.sql")
					);
			rdp.execute(getJdbcTemplate().getDataSource());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	@Override
	public boolean dropDatabase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean encryptAllPassword() {
		try {
		String sql = "SELECT username FROM user_data";
		List<String> usernameList = getJdbcTemplate().queryForList(sql, String.class);
		for(String username: usernameList) {
			String sql2 = "UPDATE user_data"
					+ " SET password=? WHERE username=?";
			getJdbcTemplate().update(sql2, encoder.encode(username), username);
			
		}
		return true;
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

}
