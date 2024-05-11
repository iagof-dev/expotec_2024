DROP DATABASE expotec;

CREATE DATABASE expotec;

USE expotec;

CREATE TABLE players(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(64) NOT NULL,
time_per_round varchar(15) not null,
time_per_game varchar(15) NOT NULL
);
