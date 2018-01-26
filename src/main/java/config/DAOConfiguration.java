package config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.DatabaseDAO;
import dao.UserDAO;
import dao.impl.DatabaseDAOImpl;
import dao.impl.UserDAOImpl;

@Configuration
public class DAOConfiguration {

	@Bean
	public DatabaseDAO databaseDAO(DataSource dataSource) {
		DatabaseDAO databaseDAO = new DatabaseDAOImpl();
		((JdbcDaoSupport) databaseDAO).setDataSource(dataSource);
		return databaseDAO;
	}
	
	@Bean
	public UserDAO userDAO(DataSource dataSource) {
		UserDAO userDAO = new UserDAOImpl();
		((JdbcDaoSupport) userDAO).setDataSource(dataSource);
		return userDAO;
	}

}
