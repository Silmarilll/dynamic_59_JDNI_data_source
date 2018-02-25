-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema oko_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `oko_db` ;

-- -----------------------------------------------------
-- Schema oko_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `oko_db` DEFAULT CHARACTER SET utf8 ;
USE `oko_db` ;

-- -----------------------------------------------------
-- Table `oko_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oko_db`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL,
  `authority` VARCHAR(45) NULL DEFAULT NULL,
  `enabled` TINYINT(1) NULL DEFAULT '1',
  `email` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `oko_db`.`offers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oko_db`.`offers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `text` TEXT NOT NULL,
  `users_username` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_offers_users_idx` (`users_username` ASC),
  CONSTRAINT `fk_offers_users`
    FOREIGN KEY (`users_username`)
    REFERENCES `oko_db`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
