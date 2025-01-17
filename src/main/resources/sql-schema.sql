drop 
  schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims`;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT, 
  `first_name` VARCHAR(40) DEFAULT NULL, 
  `surname` VARCHAR(40) DEFAULT NULL, 
  PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT, 
  `name` VARCHAR(50), 
  `stock_quantity` INT, 
  `price` DECIMAL(10, 2);
PRIMARY KEY (`id`)
);
