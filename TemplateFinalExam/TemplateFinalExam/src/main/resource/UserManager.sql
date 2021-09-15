/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

DROP DATABASE IF EXISTS UserManager;
CREATE DATABASE UserManager;
USE UserManager;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: Department  id, FullName, Email, Password
CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) UNIQUE KEY NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    `Role`		ENUM('User', 'Admin')
);


/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO `User`  (UserID   , FullName, 			Email,				 `Password`,			`Role`		) 
VALUES
					(1,			N'Nguyễn Thị Mỵ',	'mynt2407@gmail.com', 'Mynguyen123',		'User'	),
					(2,			N'Nguyễn Ngọc Duy',	'duynn03@gmail.com', 'duyNguyen',			'Admin'	),
                    (3,			N'Nguyễn Hùng Mạnh','hungmanh@gmail.com', 'hunGmanh1',			'User'	),
                    (4,			N'Tống Thị Nhung',	'nhung@gmail.com', 		'nhungtOng',		'User'	),
                    (5,			N'Trần Thị Kim Anh','kimoanh.tran@gmail.com', 'tran.kim',		'User'	);