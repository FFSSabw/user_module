CREATE TABLE USER (
    id INT UNSIGNED auto_increment,
    name VARCHAR(128) not null,
    email VARCHAR(256) unique not null,
    description VARCHAR(1024),
    localtion VARCHAR(512),
    username VARCHAR(128) unique not null,
    hashedPassword VARCHAR(512) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE ROLE (
    id TINYINT UNSIGNED auto_increment,
    rid TINYINT UNSIGNED not null,
    name VARCHAR(28) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE USER_ROLE_RELA (
    id INT UNSIGNED auto_increment,
    user_id INT UNSIGNED,
    role_id TINYINT UNSIGNED,
    FOREIGN KEY(user_id) REFERENCES USER(id) 
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(role_id) REFERENCES ROLE(id) 
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(id)
)ENGINE=InnoDB;