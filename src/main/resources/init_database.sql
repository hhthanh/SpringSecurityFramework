DROP TABLE IF EXISTS user_data;
DROP TABLE IF EXISTS user_login;
CREATE TABLE user_data (
	id SERIAL PRIMARY KEY,
	username varchar(20) UNIQUE NOT NULL,
	password varchar(60) NOT NULL,
	email varchar(50) NOT NULL,
	fullname varchar(100) NOT NULL
);

CREATE TABLE user_role(
	username text UNIQUE NOT NULL REFERENCES user_login(username),
	role text NOT NULL,
	PRIMARY KEY(username, role)
);

