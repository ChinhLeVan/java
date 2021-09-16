package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserRespository {
	List<User> getListUsers() throws SQLException, ClassNotFoundException;
	User getUserById(int id) throws SQLException, ClassNotFoundException;
	int deleteUser(int id) throws ClassNotFoundException, SQLException;
	boolean isUserIdExits(int id) throws ClassNotFoundException, SQLException;
	User login(String email, String password) throws Exception;
	void createUser(String fullName, String email) throws Exception;
}
