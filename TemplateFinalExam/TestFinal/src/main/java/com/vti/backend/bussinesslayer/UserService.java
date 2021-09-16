package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRespository;
import com.vti.backend.datalayer.UserRespository;
import com.vti.entity.User;

public class UserService implements IUserService {
	
	private IUserRespository userRespository;
	
	
	public UserService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userRespository = new UserRespository();
	}

	public List<User> getListUsers() throws ClassNotFoundException, SQLException {
		return userRespository.getListUsers();
	}

	public User getUserById(int id) throws ClassNotFoundException, SQLException {
		return userRespository.getUserById(id);
	}

	public int deleteUser(int id) throws ClassNotFoundException, SQLException {
		return userRespository.deleteUser(id);
	}

	public boolean isUserIdExits(int id) throws ClassNotFoundException, SQLException {
		return userRespository.isUserIdExits(id);
	}
	
	public User login(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		return userRespository.login(email, password);
	}

	public void createUser(String fullName, String email) throws Exception {
		userRespository.createUser(fullName, email);
	}
	
}
