******************************READ ME************************************

Run the Java File In This Folder 

Do Not Delete Any Files 

********************************IMPORTANT********************************

	password of your mysql account should be entered in ******** area in .java File

PRE-Requisites 

	1 - Mysql 

	2 - MysqlConnector . jar File

	3 - Environment To Run File

	4 - in Mysql run Following Commands

	TERMINAL : mysql -u "username" -p "Password"

		show databases;

		4.1 - CREATE DATABASE STUDENTS;

		4.2 - USE STUDENTS;

		4.3 - create table StudentInfo(Reg_no varchar(255),Name varchar(255),mark_1 int,mark_2 int,mark_3 int,grade varchar(255));

		4.4 - show tables; 

	5 - Setting Reg_no As Primary Key

		5.1 -  alter table StudentInfo add primary key (Reg_no);

	Reg_no as primary key since it is Unique among other fileds

Created By

Fahmi m | Sreya m c | Anand Sivaram | Shyamdev k | Vaishak p | Abhay k v
