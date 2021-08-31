package com.vti.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exercise1 {
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
		
	public void menuEx1() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		while(true) {
			System.out.println("Mời bạn chọn chức năng: \n"
					+ "1: Print info Position with id and name... \n"
					+"2: Tạo method để tạo position, user sẽ nhập vào name \n"
					+"3: Tạo method để update tên của position gồm có id = 5 thành \"Dev\" \n"
					+"4: Tạo method để delete của position theo id và user sẽ nhập vào id \n"
					+"5: Exit");
			int num = Integer.parseInt(scanner.nextLine());
			switch (num) {
			case 1: {
				System.out.println("in function");
				question2(connection);
				break;
			}
			case 2: {
				question3(connection);
				break;
			}
			case 3: {
				question4(connection);
				break;
			}
			case 4: {
				question5(connection);
				break;
			}
			case 5: {
				System.exit(1);
				break;
			}
			default:
				System.out.println("You choose wrong. Please choose again!");
				break;
			}
		}
	}
	
	public void question2(Connection connection) throws SQLException {
		String sq1 = "SELECT * FROM testing_system.position";
		Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery(sq1);
		
		while (resultset.next()) {
			System.out.println(resultset.getInt("position_id"));
			System.out.println(resultset.getString("position_name"));			
		}		
	}
		
	public void question3(Connection connection) throws SQLException {
		// create statement obj
		String sq3 = "INSERT INTO `position`(position_name)  "
					+ "VALUES					(?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sq3);
		
		// input name
		System.out.println("Mời nhập tên muốn thêm vào...\n"
				+ "Chỉ được chọn \"Dev\", \"Test\", \"Scrum Master\", \"PM\" ");
		String name = scanner.nextLine();
		//set parameter
		preparedStatement.setString(1, name);
		// Execute SQL query
		int effectedRecordAmount = preparedStatement.executeUpdate();
		System.out.println("Effected Record Amount: "+ effectedRecordAmount);
	}
	
	public void question4(Connection connection) throws SQLException {
		String sq4 = "UPDATE `position`" +
					 "SET `position_name` = ? " +
					 "WHERE `position_id` = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sq4);
		//input
		System.out.println("Nhập vị trí muốn chỉnh sửa có ID...");
		int getId = Integer.parseInt(scanner.nextLine());
		System.out.println("Nhập vào tên mới  \n"
				+"Chỉ được chọn \\\"Dev\\\", \\\"Test\\\", \\\"Scrum Master\\\", \\\"PM\\\" \"");
		String nameString = scanner.nextLine();
		//set parameter
		preparedStatement.setString(1, nameString);
		preparedStatement.setInt(2, getId);
		// Execute SQL query
		int effectedRecordAmount = preparedStatement.executeUpdate();
		System.out.println("Effected Record Amount: "+ effectedRecordAmount);
	}
	
	public void question5(Connection connection) throws SQLException {
		String sq5 = "DELETE " + 
					 "FROM `position`" + 
					 "WHERE position_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sq5);
		//input
		System.out.println("Nhập vị trí muốn delete có ID...");
		int getId = Integer.parseInt(scanner.nextLine());
				//set parameter
		preparedStatement.setInt(1, getId);
		// Execute SQL query
		int effectedRecordAmount = preparedStatement.executeUpdate();
		System.out.println("Effected Record Amount: "+ effectedRecordAmount);
	}
}
