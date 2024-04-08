create database if not exists EXPOTEC_2024;

use EXPOTEC_2024;

create table if not exists ranking(
    id int primary key auto_increment,
    nome varchar(64) not null,
    pontuacao int(3) not null,
    tempo datetime not null
);