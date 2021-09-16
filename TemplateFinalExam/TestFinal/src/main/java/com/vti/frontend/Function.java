package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.presentation.UserController;
import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.Role;
import com.vti.entity.User;

public class Function {
	UserController userController;

	public Function() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}

	public void getListUser() throws ClassNotFoundException, SQLException {
		List<User> users = userController.getListUsers();
		System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "Role", "proSkill", "expInYear");
		for (User user : users) {
			if (user instanceof Employee) {
				System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),"*********",
						user.getRole(), ((Employee) user).getProSkill(), "");
			}else if (user instanceof Admin) {
				System.out.printf("%-15s %-25s %-25s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),"*********",
						user.getRole(), "", ((Admin) user).getExpInYear()) ;
			}
			
			//System.out.println(user.toString());
		}
	}

	public void getUserbyId() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Mời bạn nhập vào Id: ");
			int id = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Vui lòng nhập lại");
			if (userController.isUserIdExits(id)) {
				System.out.println(userController.getUserById(id));
				break;
			} else {
				System.out.println("Id không tồn tại! Vui lòng nhập lại");
			}
		}
	}

	public void deleteUser() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Mời bạn nhập vào Id: ");
			int id = ScannerUtils.inputPositiveInt("Bạn phải nhập vào số nguyên dương! Vui lòng nhập lại");
			if (userController.isUserIdExits(id)) {
				userController.deleteUser(id);
				System.out.println("Xóa thành công!");
				break;
			} else {
				System.out.println("Id không tồn tại! Vui lòng nhập lại");
			}
		}
	}

	public User login() {
		while (true) {
			System.out.println("Mời bạn nhập email của account: ");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng.");
			
			System.out.println("Mời nhập password:");
			String password = ScannerUtils.inputPassword("Password phải có 6->12 ký tự và phải có ít nhất 1 chữ viết hoa");
			try {
				return userController.login(email, password);
			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}
	
	public void createUser(User user) throws Exception {
		if (user.getRole() == Role.Admin) {
			System.out.println("Nhập vào tên đầy đủ:");
			String fullName = ScannerUtils.inputName("Bạn nhập tên chưa đúng định dạng");
			
			System.out.println("Nhập vào email");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng");
			
			userController.createUser(fullName, email);
		}
	}
}
