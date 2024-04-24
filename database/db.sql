DROP DATABASE expotec;

CREATE DATABASE expotec;

USE expotec;

CREATE TABLE players(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(64) NOT NULL
);

CREATE TABLE rounds (
id INT PRIMARY KEY AUTO_INCREMENT,
id_player INT NOT NULL REFERENCES players(id),
time_per_round TIME not null,
time_per_game TIME NOT NULL
);
