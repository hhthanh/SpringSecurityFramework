package service;


public interface DatabaseService {
	
	//initial database method
	public boolean initialDatabase();
	//drop database method
	public boolean dropDatabase();
	public boolean enctyptAllPassword();
}
