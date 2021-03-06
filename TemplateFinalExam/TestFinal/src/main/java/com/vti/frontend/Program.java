package com.vti.frontend;


import com.vti.Utils.ScannerUtils;
import com.vti.entity.Role;
import com.vti.entity.User;

public class Program {
	public static void main(String[] args)
			throws Exception {
		menuLogin();
	}

	private static void menuLogin() throws Exception {
		Function function = new Function();
		System.out.println("MỜI BẠN LOGIN");
		User user = function.login();
		System.out.println("Login successfull!");
		System.out.println("Chào mừng " + user.getFullName() + "!");
		if (user.getRole() == Role.Admin) {
			menuAdmin(user);
		} else {
			menuUser(user);
		}
	}

	private static void menuUser(User user) {
		// TODO
	}

	private static void menuAdmin(User user)
			throws Exception {
		Function function = new Function();
		System.out.println("Chào mừng Admin " + user.getFullName() + "!");
		System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: In ra danh sách các User\n"
				+ "2: Tìm user theo ID\n" + "3: Xóa user theo id\n" + "4: Login\n" + "5: Thêm user\n " + "6: Thoat khoi chuong trinh\n ");

		while (true) {
			System.out.print("Moi ban nhap chuc nang: ");
			int choose = ScannerUtils.inputFunction(1, 6, "Ban chi duoc chon tu 1 --> 6. Mời nhập lại!");

			switch (choose) {
			case 1:
				function.getListUser();
				break;
			case 2:
				function.getUserbyId();
				break;
			case 3:
				function.deleteUser();
				break;
			case 4:
				function.login();
				break;
			case 5:
				function.createUser(user);
				break;
			case 6:
				System.out.println("bạn đã thoát khỏi chương trình!");
				return;
			}
		}
	}
}
