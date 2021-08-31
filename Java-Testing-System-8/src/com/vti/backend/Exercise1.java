package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import com.vti.entity.Student;

public class Exercise1 {
	public static Scanner scanner = new Scanner(System.in);
	
	//==================================QUESTION 1==================================
	private ArrayList<Student> listStudents = new ArrayList<>();
	
	public void insertStudent() {
		System.out.println("Nhap so vinh vien muon them");
		int num = Integer.parseInt(scanner.nextLine());
		for(int i = 0; i < num -3; i++) {
			Student student = new Student("Student "+(i+1));
			listStudents.add(student);
		}
		Student student1 = new Student("Student namesake");
		Student student2 = new Student("Student namesake");
		Student student3 = new Student("Student namesake");
		listStudents.add(student1);
		listStudents.add(student2);
		listStudents.add(student3);
		}
	
	public void printListStudent() {
		for (Student student : listStudents) {
			System.out.println(student.toString());
		}
	}
	
	public int menu() {
		System.out.println("Chọn chức năng: /n" +"1.In ra tổng số phần tử của students \n"
							+"2.Lấy phần tử thứ 4 của students \n" 
							+"3.In ra phần tử đầu và phần tử cuối của student \n"
							+"4.Thêm 1 phần tử vào vị trí đầu của students \n" 
							+"5: Thêm 1 phần tử vào vị trí cuối của students \n" 
							+"6: Đảo ngược vị trí của students \n" 
							+"7: Tìm kiếm student theo id \n"
							+"8: Tìm kiếm student theo name \n"
							+"9: Tạo 1 method để in ra các student có trùng tên \n"
							+"10: Xóa name của student có id = 2 \n"
							+"11: Delete student có id = 5 \n" 
							+"12: Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies \n"
							+"13: print list student \n" 
							+"14: Exit");
		int chose = Integer.parseInt(scanner.nextLine());
		return chose;
				}
	
	public void Question1() {
		insertStudent();
		while(true) {
		int chose = menu();
		switch (chose) {
		case 1: {
			//1.In ra tổng số phần tử của students
			System.out.println(listStudents.size());
			break;
		}
		case 2: {
			//2.Lấy phần tử thứ 4 của students
			System.out.println(listStudents.get(3).toString());
			break;
		}
		case 3: {
			//3.In ra phần tử đầu và phần tử cuối của student
			listStudents.get(0).toString();
			listStudents.get(listStudents.size() -1);
			break;
		}
		case 4: {
			//4.Thêm 1 phần tử vào vị trí đầu của students
			System.out.println("Nhap ten student muon them vao vi tri cuoi...");
			String nameFirst = scanner.nextLine();
			Student studentFirst = new Student(nameFirst);
			listStudents.add(0, studentFirst);
			break;
		}
		case 5: {
			//5: Thêm 1 phần tử vào vị trí cuối của students
			System.out.println("Nhap ten student muon them vao vi tri cuoi...");
			String nameLast = scanner.nextLine();
			Student studentLast = new Student(nameLast);
			listStudents.add(studentLast);
			break;
		}
		case 6: {
			//Đảo ngược vị trí của students
			System.out.println("Dao nguoc vi tri student: ");
			Collections.reverse(listStudents);
			break;
		}
		case 7: {
			//Tìm kiếm student theo id
			System.out.println("nhap Id student muon tim kiem...");
			int idSearch = Integer.parseInt(scanner.nextLine());
			for (Student student : listStudents) {
				if (student.getId() == idSearch) {
					System.out.println(student.toString());
				}
			}
		}
		case 8: {
			//8: Tìm kiếm student theo name
			System.out.println("nhap name student muon tim kiem...");
			String nameSearch = scanner.nextLine();
			for (Student student : listStudents) {
				if (student.getName() == nameSearch) {
					System.out.println(student.toString());
				}
			}
			break;
		}
		case 9: {
			//9: Tạo 1 method để in ra các student có trùng tên
			int[] check = new int[listStudents.size()]; // dùng để lưu id cái student đã in ra
			System.out.println("Cac sinh vien trung ten.");
			for (int i = 0; i < listStudents.size(); i++) {
				for (int j = i+1; j < listStudents.size(); j++) {
					if (listStudents.get(i).getName().equals(listStudents.get(j).getName())) {
						System.out.println(listStudents.get(i).toString());
					}
				}
			}
			break;
		}
		case 10: {
			// Xóa name của student có id = 2
			for (Student student : listStudents) {
				if (student.getId() == 2) {
					student.setName(null);
				}
			}
			System.out.println("Da xoa name cua student có id = 2");
			break;
		}
		case 11: {
			//11: Delete student có id = 5
			for (int i = 0; i < listStudents.size(); i++) {
				if (listStudents.get(i).getId() == 2) {
					listStudents.remove(i);
				}
			}
			System.out.println("Da xoa student có id = 5");
			break;
		}
		case 12: {
			//Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies
			ArrayList<Student> studentCopies = new ArrayList<>();
			Collections.copy(studentCopies, listStudents);
			break;
		}
		case 13: {
			System.out.println("LIST STUDENTS.....");
			printListStudent();
		}
		
		case 14: {
			// Exit
			System.exit(1);
			break;
		}
		
		default:
			System.out.println("Ban da chon sai chuc nang. vui long chon lai");
		}
	}}

	//==================================QUESTION 2==================================
	
	private Stack<Student> stackStudents = new Stack<>();
	public void insertStudentToStack() {
		Student student1 = new Student("Nguyen Van Nam");
		Student student2 = new Student("Nguyen Van Huyen");
		Student student3 = new Student("Tran Van Nam");
		Student student4 = new Student("Nguyen Van A");
		stackStudents.push(student1);
		stackStudents.push(student2);
		stackStudents.push(student3);
		stackStudents.push(student4);
	}
	
	public void printStudenByStack() {
		int size = stackStudents.size();
		for(int i = 0 ; i< size; i++) {
			System.out.println(stackStudents.pop().toString());// pop lấy phần tử đầu tiên ra. sau khi lấy phần tử nào thì stack bị mất phần tử đó
		}
	}
	
	private Queue<Student> queueStudents = new LinkedList<Student>();
	public void insertStudentToQueue() {
		Student student1 = new Student("Nguyen Van Nam");
		Student student2 = new Student("Nguyen Van Huyen");
		Student student3 = new Student("Tran Van Nam");
		Student student4 = new Student("Nguyen Van A");
		queueStudents.offer(student1);
		queueStudents.offer(student2);
		queueStudents.offer(student3);
		queueStudents.offer(student4);
	}
	
	public void printStudenByQueue() {
		int size = queueStudents.size();
		for(int i = 0 ; i< size; i++) {
			System.out.println(queueStudents.poll().toString());
		}
	}
	
	public void menuQuestion2() {
		while (true) {
			System.out.println("Moi ban chon chuc nang... \n"+"1: In ra thứ tự tới của các học sinh theo thứ tự từ muộn nhất tới sớm nhất \n"
								+"2: In ra thứ tự tới của các học sinh theo thứ tự sớm nhất tới muộn nhất"
								+"3: Exit");
			int choose = Integer.parseInt(scanner.nextLine());
			switch (choose) {
			case 1: {
				insertStudentToStack();
				printStudenByStack();
				break;
			}
			case 2: {
				insertStudentToQueue();
				printStudenByQueue();
				break;
			}
			case 3: {
				System.exit(1);
			}
			default:
				System.out.println("ban da chon sai chuc nang. Moi chon lai!");
				break;
			}
		}
	}
	
	//==================================QUESTION 4====================================
	
	private Set<String> setStudents = new HashSet<>();
	public void insertStudentInSet() {
		System.out.println("Nhap so vinh vien muon them");
		int num = Integer.parseInt(scanner.nextLine());
		for(int i = 0; i < num -2; i++) {
			Student student = new Student("Student Set "+(i+1));
			setStudents.add(student.getName());
		}
		Student studentSet1 = new Student("Student Set 1");
		Student studentSet2 = new Student("Student Set 2");
		setStudents.add(studentSet1.getName());
		setStudents.add(studentSet2.getName());
	}
	
	public void question4PrintSet() {
		insertStudentInSet();
		for (String nameStudent : setStudents) {
			System.out.println(nameStudent.toString());
		}
	}
	//=================================QUESTION 5======================================
	public void sortNameSet() {
		insertStudentInSet();
		List<String> sortedList = new ArrayList<>(setStudents);
		Collections.sort(sortedList);
		for (String studentName : sortedList) {
			System.out.println(studentName.toString());
		}
	}
	
	//================================ QUESTION 6=================================
	private Map<Integer, String> studentsMap = new HashMap<>();
	public void insertStudentMap() {
		System.out.println("Nhap so vinh vien muon them");
		int num = Integer.parseInt(scanner.nextLine());
		for(int i = num; i >= 0; i--) {
			studentsMap.put(i, "Student nameMap "+(i+1));
		}
		System.out.println("ban da them "+num+" sinh vien la.");
		for (int i = studentsMap.size() -1;i >=0; i--) {
			System.out.println(studentsMap.get(i).toString());
		}
	}
	
	//===============================QUESTION 7==================================
	public void printKeyStudent() {
		for (int key: studentsMap.keySet()) {
			System.out.println(key);
		}
	}
	
	public void printValueStudent() {
		for (String value :studentsMap.values()) {
			System.out.println(value);
		}
	}
	
	public void printStudentSortByName() {
		LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
		studentsMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		
		for (int i = 0; i < sortedMap.size(); i++) {
			System.out.println(sortedMap.get(i));
		}
	}
	
	public void convertMapStudentToSet() {
		//Convert Map keys to Set
        Set<Integer> keySet= new HashSet<Integer>(studentsMap.keySet());
        keySet.forEach(key-> System.out.println(key));

        //Convert Map values to Set
        Set<String> valueSet= new HashSet<String>(studentsMap.values());
        valueSet.forEach(value-> System.out.println(value));
		
	}
	
	public void menuQuestion7() {
		insertStudentMap();
		while(true) {
		System.out.println("Moi ban chon chuc nang... \n"
							+"1: in ra key cua student \n"
							+"2: in ra value cua student \n"
							+"3: In ra danh sach student duoc sap xep theo ten cua student \n"
							+"4: Chuyen doi map student sang set"
							+"5: Exit");
		int num = Integer.parseInt(scanner.nextLine());
		switch (num) {
		case 1: {
			//in ra key cua student
			printKeyStudent();
			break;
		}
		case 2: {
			//in ra value cua student
			printValueStudent();
			break;
		}
		case 3: {
			//In ra danh sach student duoc sap xep theo ten cua student
			printStudentSortByName();
			break;
		}
		case 4: {
			//Chuyen doi map student sang set
			convertMapStudentToSet();
			break;
		}
		case 5: {
			System.exit(1);
		}
		default:
			System.out.println("Ban da chon sai chuc nang. Vui long chon lai....");
		}
	}
	}
}
