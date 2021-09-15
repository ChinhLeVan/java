package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;

public class DepartmentDao {
	public static Scanner scanner = new Scanner(System.in);
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username ="root";
		String password = "Root";
		
		// register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2: get a Database Connection
		Connection connection = (Connection) DriverManager.getConnection(url,username,password);
		System.out.println("Connect success!");
		return connection;
		}
	
	public void menuEx2() throws ClassNotFoundException, SQLException {		
			Connection connection = getConnection();
			while(true) {
				System.out.println("Mời bạn chọn chức năng: \n"
								+ "1: In ra danh sách tất cả các Department \n"
								+ "2: In ra Department có id được nhập từ người dùng \n"
								+ "3: Tạo method check department name có tồn tại hay không \n"
								+ "4: Tạo method để người dùng có thể tạo được department  \n"
								+ "5: Update department name \n"
								+ "6: Xóa department theo id mà user nhập vào \n"
								+ "7: Exit");
				int num = Integer.parseInt(scanner.nextLine());
				switch (num) {
				case 1: {
					System.out.println("in function");
					question1(connection);
					break;
				}
				case 2: {
					while (true) {
						try {
							Department departmentResult = getDepartmentById(connection);
							System.out.println(departmentResult.toString());
							break;
						} catch (NullPointerException e) {
							System.out.println("Try again!!! ");
						}	
					}	
					break;
				}
				case 3: {
					System.out.println("Enter name you can find: ");
					String name = scanner.nextLine();
					if(isDepartmentNameExists(connection,name)) {
						System.out.println("Tồn tại "+ name);
					}
					else {
						System.out.println("Không tồn tại "+name);
					};
					break;
				}
				case 4: {
					createDepartment(connection);
					break;
				}
				case 5: {
					System.out.println("Enter ID");
					int id = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter newName");
					String newName = scanner.nextLine();
					updateDepartmentName(connection, id, newName);
					break;
				}
				case 6: {
					System.out.println("Enter Id");
					int id = Integer.parseInt(scanner.nextLine());
					deleteDepartment(connection, id);
					break;
				}
				case 7: {
					System.exit(1);
					break;
				}
				default:
					System.out.println("You choose wrong. Please choose again!");
					break;
				}
			}	
		}
	
	//=================================Question 1===============================================
	public void question1(Connection connection) throws SQLException {
		List<Department> arrDepartments = new ArrayList<Department>();
		
		String sq1 = "SELECT * FROM `department`";
		Statement statement = connection.createStatement();
		
		ResultSet resultset = statement.executeQuery(sq1);
				
		while (resultset.next()) {
			Department department = new Department(resultset.getInt("department_id"), resultset.getString("department_name"));
			arrDepartments.add(department);		
		}
		for (Department department : arrDepartments) {
			System.out.println(department.toString());
		}
	} 
	//===================================Question 23==============================================
	public Department getDepartmentById(Connection connection) throws SQLException {
		// create statement obj
		String sq3 = "SELECT * FROM `department`"
					+"WHERE department_id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sq3);
		System.out.println("Enter id you can find: ");
		int numId = Integer.parseInt(scanner.nextLine());
		preparedStatement.setInt(1, numId);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			int id = resultSet.getInt("department_id");
			String name = resultSet.getString("department_name");
			Department department = new Department(id, name);
			return department;
		} else {
			System.out.println("Cannot find department which has id= " +numId);
			return null;
		}
		
	}
	//=================================Question 4==============================================
	public boolean isDepartmentNameExists(Connection connection, String name) throws SQLException {
		String sq3 = "SELECT * FROM `department`"
				+"WHERE department_name = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sq3);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}
	//=================================Question 5=============================================
	public void createDepartment(Connection connection) throws SQLException {
		String sq3 = "INSERT INTO `department`(department_name)  "
					+ "VALUES					(?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sq3);
		// input name
		System.out.println("Mời nhập tên muốn thêm vào...");
		String name = scanner.nextLine();
		if (isDepartmentNameExists(connection, name)) {
			System.out.println("Department name is exists");
		} else {
			//set parameter
			preparedStatement.setString(1, name);
			// Execute SQL query
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Effected Record Amount: "+ effectedRecordAmount);
		}	
	}
	//=================================Question 6============================================
	public void updateDepartmentName(Connection connection, int id, String newname) throws SQLException {
		if (isDepartmentIdExists(connection, id)) {
			if (isDepartmentNameExists(connection, newname)) {
				System.out.println("Department name is Exists!");
			} else {
				String sq4 = "UPDATE `department`" +
							"SET `department_name` = ? "+
							"WHERE `department_id` = ? ";
				PreparedStatement preparedStatement = connection.prepareStatement(sq4);
				preparedStatement.setInt(2, id);
				preparedStatement.setString(1, newname);
				int effectedRecordAmount = preparedStatement.executeUpdate();
				if(effectedRecordAmount == 1) {
					System.out.println("You done update!");
					System.out.println("Effected Record Amount: "+ effectedRecordAmount);
				}
			}
		} else {
			System.out.println("Cant find department which has id= "+id);
		}
	}
	public boolean isDepartmentIdExists(Connection connection, int id) throws SQLException {
		String sq6 = "SELECT * FROM `department`"
				+"WHERE department_id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sq6);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}
	//==================================Question 7===============================================
	public void deleteDepartment(Connection connection, int id) throws SQLException {
		if(isDepartmentIdExists(connection, id)) {
			String sq7 = "DELETE " + 
					 	 "FROM `department`" + 
					 	 "WHERE department_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sq7);
			preparedStatement.setInt(1, id);
			int effectedRecordAmount = preparedStatement.executeUpdate();
			if(effectedRecordAmount == 1) {
				System.out.println("You done delete!");
				System.out.println("Effected Record Amount: "+ effectedRecordAmount);
			}
		}else {
			System.out.println("Cant find department which has id= "+id);
		}
	}
}
