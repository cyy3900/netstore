drop database if exists netuser;
create database netstore;
use netstore;
create table user(
id int auto_increment,
username varchar(30) not null,
password varchar(30) not null,
email varchar(30),
active int,
registerDate date,
primary key (id)
);