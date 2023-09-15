DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `item`;

CREATE TABLE IF NOT EXISTS `item` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50),
    `stock_quantity` INT(11),
    `price` DECIMAL(10,2);
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


