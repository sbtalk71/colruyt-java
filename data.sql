##SQL Script for Database

CREATE TABLE emp (empno int NOT NULL primary key,name varchar(20) DEFAULT NULL,address varchar(20) DEFAULT NULL,salary decimal DEFAULT NULL);

insert into emp(empno,name,address,salary) values (101,'Aman','Kanpur',56000);
insert into emp(empno,name,address,salary) values(102,'Jagan','Hyderabad',66000);
insert into emp(empno,name,address,salary) values(102,'Raja','bangalore',58000);
insert into emp(empno,name,address,salary) values(103,'James','Mumbai',76000);
insert into emp(empno,name,address,salary) values(104,'Rupal','Noida',96000);
insert into emp(empno,name,address,salary) values(105,'Karan','Mumbai',56000);
insert into emp(empno,name,address,salary) values(106,'Narendra','Delhi',56000);
insert into emp(empno,name,address,salary) values(107,'Amit','Delhi',56000);
insert into emp(empno,name,address,salary) values(108,'Arun','Chennai',56000);
insert into emp(empno,name,address,salary) values(109,'Kishore','Kochi',56000);


##Data WIth Relation
======================

create table MYDEPT (DNO integer not null,
DNAME varchar(15),
MANAGER varchar(15),
primary key (DNO));

create table MYEMP (EMPNO integer 
not null, NAME varchar(15),
SALARY double,
ADDRESS varchar(15),
DNO integer, primary key (EMPNO));

alter table MYEMP add constraint FK_12many foreign key(DNO) references MYDEPT (DNO);

insert into MYDEPT (DNO,DNAME,MANAGER) values (10,'Accounts','Rahul');
insert into MYDEPT (DNO,DNAME,MANAGER) values (20,'IT','Manish');
insert into MYDEPT (DNO,DNAME,MANAGER) values (30,'HR','Ankur');

insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (100,'Shantanu',30000,'Hyd',10);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (101,'Rajiv',30000,'Hyd',10);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (102,'Shankar',30000,'Blore',20);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (103,'Madhu',30000,'Hyd',20);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (104,'Kannan',30000,'Dhanbad',20);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (105,'Vimal',30000,'Hyd',10);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (106,'Rupa',30000,'Bhopal',30);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (107,'Pavan',30000,'Hyd',30);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (108,'Kalyan',30000,'Chennai',30);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (109,'Bhavesh',30000,'Hyd',20);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (110,'Arun',30000,'Hyd',20);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (111,'Kanti',30000,'Hyd',10);
insert into MYEMP (EMPNO,NAME,SALARY,ADDRESS,DNO) values (112,'Suraj',30000,'Hyd',10);
commit;
