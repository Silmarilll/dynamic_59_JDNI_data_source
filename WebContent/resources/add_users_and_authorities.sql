CREATE TABLE users (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL,
  `enabled` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`username`));


-- -----------------------------------------------------
-- Table `mydb`.`authorities`
-- -----------------------------------------------------
CREATE TABLE authorities (
  `username` VARCHAR(60) NOT NULL,
  `authority` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));
  
  ALTER TABLE users add column email VARCHAR(40);
  
  insert into users (username, password) values("Mike", 1);
insert into users (username, password) values("Olga", 1);
insert into users (username, password) values("admin", "admin");

insert into authorities (username, authority) values ("Mike", "user");
insert into authorities (username, authority) values ("Olga", "user");
insert into authorities (username, authority) values ("admin", "admin");
