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
import com.vti.Utils.ScannerUtils;
import com.vti.entity.Admin;
import com.vti.entity.Employee;
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
			
			String listEmployee = "SELECT e.UserID, FullName, Email, `Role`, 	`Password`, ProSkill  FROM Employee e\r\n" + 
					"INNER JOIN `User` u ON u.UserID = e.UserID";
			ResultSet resultSetE = statement.executeQuery(listEmployee);
			
			while (resultSetE.next()) {
				int userId = resultSetE.getInt("UserID");
				String fullName = resultSetE.getString("FullName");
				String email = resultSetE.getString("Email");
				String passWord = resultSetE.getString("Password");
				Role role = Role.valueOf(resultSetE.getString("Role"));
				String proSkill = resultSetE.getString("ProSkill");
				
				Employee employee = new Employee(userId, fullName, email, passWord, role, proSkill);
				users.add(employee);
			}	
			String listAdmin = "SELECT a.UserID, FullName, Email, `Role`, 	`Password`, ExpInYear  FROM Admin a\r\n" + 
					"INNER JOIN `User` u ON u.UserID = a.UserID";
			ResultSet resultSetA = statement.executeQuery(listAdmin);
			
			while (resultSetA.next()) {
				int userId = resultSetA.getInt("UserID");
				String fullName = resultSetA.getString("FullName");
				String email = resultSetA.getString("Email");
				String passWord = resultSetA.getString("Password");
				Role role = Role.valueOf(resultSetA.getString("Role"));
				int expInYear = resultSetA.getInt("ExpInYear");
				
				Admin admin = new Admin(userId, fullName, email, passWord, role, expInYear);
				users.add(admin);
			}	
			return users;	
		} finally {
			connection.close();
		}
		
	
	}

	public User getUserById(int id) throws SQLException, ClassNotFoundException {
		
		try {
			connection = jdbcUltils.connect();
			
			String sqlE = "SELECT e.UserID, FullName, Email, `Role`, 	`Password`, ProSkill  FROM Employee e \r\n" +
							"INNER JOIN `User` u ON u.UserID = e.UserID  WHERE e.UserID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlE);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSetE = preparedStatement.executeQuery();
			
			if (resultSetE.next()) {
				int userId = resultSetE.getInt("UserID");
				String fullName = resultSetE.getString("FullName");
				String email = resultSetE.getString("Email");
				String password = resultSetE.getString("Password");
				Role role = Role.valueOf(resultSetE.getString("Role"));
				String proSkill = resultSetE.getString("ProSkill");

				Employee employee = new Employee(userId, fullName, email, password, role, proSkill);

				return employee;
			} else{
				String sqlA = "SELECT a.UserID, FullName, Email, `Role`, 	`Password`, ExpInYear  FROM Admin a \r\n" + 
							"INNER JOIN `User` u ON u.UserID = a.UserID  WHERE a.UserID = ?";
				PreparedStatement preparedStatementA = connection.prepareStatement(sqlA);
				preparedStatementA.setInt(1, id);
				
				ResultSet resultSetA = preparedStatementA.executeQuery();
				
				if (resultSetA.next()) {
					int userId = resultSetA.getInt("UserID");
					String fullName = resultSetA.getString("FullName");
					String email = resultSetA.getString("Email");
					String password = resultSetA.getString("Password");
					Role role = Role.valueOf(resultSetA.getString("Role"));
					int expInYear = resultSetA.getInt("ExpInYear");

					Admin admin = new Admin(userId, fullName, email, password, role, expInYear);

					return admin;
			}	}
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

	public void createUser(String fullName, String email) throws Exception {
		try {
			connection = jdbcUltils.connect();
			String passWord = "123456"; 
			String role = Role.User.name();
			
			
			String sql = "INSERT INTO User(FullName,Email,Password,Role) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, fullName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, passWord);
			preparedStatement.setString(4, role);
			
			int affectedRows = preparedStatement.executeUpdate();
			
			
			if (affectedRows>0) {
					createEmployee();
					//System.out.println("Bạn đã tạo thành công!");
				}
				else {
				throw new Exception("Bạn chưa tạo thành công");
			}
		} finally {
			connection.close();
		}
	}
	
	public void createEmployee() throws ClassNotFoundException, SQLException {
		try {
			String sqlE = "SELECT MAX(UserID) AS UserID FROM User";
			connection = jdbcUltils.connect();
			Statement statement = connection.createStatement();
			ResultSet resultSetE = statement.executeQuery(sqlE);
			int UserId =0;
			if (resultSetE.next()) {
				UserId = resultSetE.getInt("UserID");
				System.out.println("Nhập vào proSkill của employee");
				String proSkill = ScannerUtils.inputString("Nhập sai");		
				String sqlInsertE = "INSERT INTO Employee(UserID,ProSkill) VALUES(?,?)";
				PreparedStatement preparedStatementE = connection.prepareStatement(sqlInsertE);

				preparedStatementE.setInt(1, UserId);
				preparedStatementE.setString(2, proSkill);
				int affectedRowsE = preparedStatementE.executeUpdate();
				if (affectedRowsE>0) {
					System.out.println("Bạn đã tạo thành công!");
				}
			}
		} finally {
			connection.close();
		}
	}
	
}
