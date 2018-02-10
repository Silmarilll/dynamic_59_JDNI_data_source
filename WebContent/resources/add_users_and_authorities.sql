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