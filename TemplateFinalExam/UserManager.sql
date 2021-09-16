/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

DROP DATABASE IF EXISTS UserManager;
CREATE DATABASE UserManager;
USE UserManager;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: Department  id, FullName, Email, Password
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) UNIQUE KEY NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    `Role`		ENUM('User', 'Admin')
);

DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin`(
	UserID 		TINYINT UNSIGNED PRIMARY KEY,
	ExpInYear	TINYINT UNSIGNED	NOT NULL,
    FOREIGN KEY(UserID) REFERENCES `User`(UserID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee`(
	UserID 		TINYINT UNSIGNED PRIMARY KEY,
	ProSkill	VARCHAR(20) NOT NULL,
    FOREIGN KEY(UserID) REFERENCES `User`(UserID) ON DELETE CASCADE
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO `User`  ( FullName, 			Email,				 `Password`,			`Role`		) 
VALUES
					(N'Nguyễn Thị Mỵ',		'mynt2407@gmail.com',	 'Mynguyen123',		'User'	),
					(N'Lê Văn Chính',		'lechinh29@gmail.com', 	'Chinhle',			'Admin'	),
                    (N'Nguyễn Hùng Mạnh',	'hungmanh@gmail.com',	 'hunGmanh1',		'User'	),
                    (N'Tống Thị Nhung',		'nhung@gmail.com', 		'nhungtOng',		'User'	),
                    (N'Trần Thị Kim Anh',	'kimoanh.tran@gmail.com', 'tran.kim',		'User'	);
                    
INSERT INTO `Admin`(UserID, ExpInYear)
VALUES				(2,	3);

INSERT INTO `Employee`(UserID, ProSkill)
VALUES				(1,	'sql'),
					(3, 'java'),
                    (4, 'C++'),
                    (5, 'python');