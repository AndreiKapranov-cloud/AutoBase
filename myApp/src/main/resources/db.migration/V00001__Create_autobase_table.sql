-- MySQL Script generated by MySQL Workbench
-- Mon Jul 19 23:02:23 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Autobase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Autobase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Autobase` DEFAULT CHARACTER SET utf8;
USE `Autobase`;

-- -----------------------------------------------------
-- Table `Autobase`.`auto_base`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Autobase`.`auto_base`
(
    `auto_base_id`         INT         NOT NULL AUTO_INCREMENT,
    `address`              VARCHAR(45) NOT NULL,
    `name_of_organization` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`auto_base_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Autobase`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Autobase`.`role`
(
    `role_id` INT         NOT NULL AUTO_INCREMENT,
    `role`    VARCHAR(45) NULL,
    PRIMARY KEY (`role_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Autobase`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Autobase`.`user`
(
    `user_id`          INT          NOT NULL AUTO_INCREMENT,
    `username`         VARCHAR(16)  NOT NULL,
    `email`            VARCHAR(255) NOT NULL,
    `password`         VARCHAR(32)  NOT NULL,
    `create_date`      DATE         NOT NULL,
    `user_second_name` VARCHAR(45)  NOT NULL,
    `ready`            TINYINT      NOT NULL,
    `role_id`          INT          NOT NULL,
    PRIMARY KEY (`user_id`),
    INDEX `role_id_idx` (`role_id` ASC) VISIBLE,

    FOREIGN KEY (`role_id`)
        REFERENCES `Autobase`.`role` (`role_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);



-- -----------------------------------------------------
-- Table `Autobase`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Autobase`.`orders`
(
    `order_id`         INT         NOT NULL AUTO_INCREMENT,
    `term_of_delivery` DATE        NOT NULL,
    `weight_kg`        INT         NOT NULL,
    `delivery_address` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`order_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Autobase`.`auto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Autobase`.`auto`
(
    `auto_id`                  INT         NOT NULL AUTO_INCREMENT,
    `number`                   VARCHAR(45) NOT NULL,
    `carrying_capacity`        INT         NOT NULL,
    `max_weight_with_cargo_kg` INT         NOT NULL,
    `max_volume_m3`            INT         NOT NULL,
    `technical_inspection`     TINYINT     NOT NULL,
    `user_id`                  INT         NOT NULL,
    PRIMARY KEY (`auto_id`),
    INDEX `user_id_idx` (`user_id` ASC) VISIBLE,

    FOREIGN KEY (`user_id`)
        REFERENCES `Autobase`.`user` (`user_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Autobase`.`trip`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Autobase`.`trip`
(
    `trip_id`       INT     NOT NULL AUTO_INCREMENT,
    `distance_km`   INT     NOT NULL,
    `auto_base_id`  INT     NOT NULL,
    `order_id`      INT     NOT NULL,
    `driver_id`     INT     NOT NULL,
    `dispatcher_id` INT     NOT NULL,
    `finished`      TINYINT NOT NULL,
    PRIMARY KEY (`trip_id`),
    INDEX `unp_idx` (`auto_base_id` ASC) VISIBLE,
    INDEX `order_id_idx` (`order_id` ASC) VISIBLE,
    INDEX `driver_id_idx` (`driver_id` ASC) VISIBLE,
    INDEX `dispatcher_id_idx` (`dispatcher_id` ASC) VISIBLE,

    FOREIGN KEY (`auto_base_id`)
        REFERENCES `Autobase`.`auto_base` (`auto_base_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (`order_id`)
        REFERENCES `Autobase`.`orders` (`order_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (`driver_id`)
        REFERENCES `Autobase`.`user` (`user_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (`dispatcher_id`)
        REFERENCES `Autobase`.`user` (`user_id`)
        ON DELETE CASCADE
        ON UPDATE CASCADE
)
    ENGINE = InnoDB;



SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;