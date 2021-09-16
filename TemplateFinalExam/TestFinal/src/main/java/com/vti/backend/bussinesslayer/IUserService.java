package com.vti.backend.bussinesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.User;

public interface IUserService {
	List<User> getListUsers() throws ClassNotFoundException, SQLException;

	User getUserById(int id) throws ClassNotFoundException, SQLException;

	int deleteUser(int id) throws ClassNotFoundException, SQLException;

	boolean isUserIdExits(int id) throws ClassNotFoundException, SQLException;

	User login(String email, String password) throws Exception;
	
	void createUser(String fullName, String email) throws Exception;
}
