package com.vti.frontend;

import java.sql.SQLException;

import com.vti.backend.DepartmentDao;
import com.vti.entity.Exercise1;



public class Programe {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Exercise1 exercise1 = new Exercise1();
//		exercise1.menuEx1();
		DepartmentDao departmentDao = new DepartmentDao();
		departmentDao.menuEx2();
	}
}
