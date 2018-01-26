package dao;

public interface DatabaseDAO {
	public boolean initDatabase();
	public boolean dropDatabase();
	public boolean encryptAllPassword();
}
