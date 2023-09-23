CREATE TABLE users (
user_id INT(11) NOT NULL AUTO_INCREMENT primary key,
username varchar(25) unique not null,
password varchar(25) not null
);