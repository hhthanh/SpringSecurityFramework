package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import dao.DatabaseDAO;
import service.DatabaseService;

public class DatabaseServiceImpl implements DatabaseService {

	@Autowired
	private DatabaseDAO databaseDAO;
	@Override
	public boolean initialDatabase() {
		
		// initial the database
		return databaseDAO.initDatabase();
	}

	@Override
	public boolean dropDatabase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enctyptAllPassword() {
		return databaseDAO.encryptAllPassword();
	}

}
