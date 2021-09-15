package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.Utils.JdbcUltils;
import com.vti.entity.Role;
import com.vti.entity.User;

public class UserRespository implements IUserRespository {
	private JdbcUltils jdbcUltils;
	private Connection connection;
	
	public UserRespository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUltils = new JdbcUltils();
	}

	public List<User> getListUsers() throws SQLException, ClassNotFoundException {
		List<User> users = new ArrayList<User>();
		
		try {
			connection = jdbcUltils.connect();
			Statement statement = connection.createStatement();
			
			String listUser = "SELECT * FROM usermanager.user";
			ResultSet resultSet = statement.executeQuery(listUser);
			
			while (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String passWord = resultSet.getString("Password");
				Role role = Role.valueOf(resultSet.getString("Role"));
				
				User user = new User(userId, fullName, email, passWord, role);
				users.add(user);
			}
			return users;
			
		} finally {
			connection.close();
		}
	
	}

	public User getUserById(int id) throws SQLException, ClassNotFoundException {
		
		try {
			connection = jdbcUltils.connect();
			
			String sql = "SELECT * FROM usermanager.user WHERE UserID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				Role role = Role.valueOf(resultSet.getString("Role"));

				User user = new User(userId, fullName, email, password, role);

				return user;
			}
			return null;
						
		} finally {
			connection.close();
		}
	}

	
	public int deleteUser(int id) throws ClassNotFoundException, SQLException {
		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = " DELETE " + " FROM `User` " + " WHERE UserID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query

			int effectedRecodAmount = preparedStatement.executeUpdate();

			// Step 5: Handling result
			return effectedRecodAmount;

		} finally {
			connection.close();
		}
	}

	public boolean isUserIdExits(int id) throws ClassNotFoundException, SQLException {
		try {

			// step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT * FROM usermanager.user " + " WHERE UserID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			connection.close();
		}
	}

	public User login(String email, String password) throws Exception {
		
		try {
			connection = jdbcUltils.connect();
			
			String sql = "SELECT* FROM Usermanager.user WHERE Email = ? AND Password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				Role role = Role.valueOf(resultSet.getString("Role"));

				User user = new User(userId, fullName, email, password, role);

				return user;
			} else {
				throw new Exception("Tài khoản hoặc mật khẩu sai!");
			}
			
		} finally {
			connection.close();
		}

}
	
}
