create table IF NOT EXISTS T_USER(USR_USERNAME varchar(100),USR_PASSWORD varchar(100), USR_EMAIL varchar(100));
create table IF NOT EXISTS DUMMY(DUMMY_VALUE varchar(10));
create table IF NOT EXISTS Person(id integer identity primary key , name varchar(100), gender varchar(1), dateOfBirth date);
