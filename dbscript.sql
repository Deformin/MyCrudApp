DROP DATABASE IF EXISTS test;
CREATE DATABASE test COLLATE utf8_bin;

USE test;

DROP TABLE IF EXISTS part;
CREATE TABLE part(
  id        INT(11)      NOT NULL AUTO_INCREMENT,
  name      VARCHAR(100) NOT NULL,
  isNeeded  BIT(1)       NOT NULL DEFAULT FALSE,
  amount    INT(11)      NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO part (name, isNeeded, amount) VALUES
       ('motherboard ASUS', false, 3),
       ('sound card ASUS', false, 2),
       ('processor AMD', true, 2),
       ('lighting kit DeepCool', false, 0),
       ('HDD drive Seagate', false, 1),
       ('computer case 3Cott', true, 10),
       ('RAM Crucial', true, 10),
       ('SSD drive AData', true, 15),
       ('video card ASUS', false, 7),
       ('motherboard MSI', true, 5),
       ('sound card Creative', false, 9),
       ('processor Intel', true, 7),
       ('lighting kit NZXT', false, 14),
       ('HDD drive WD', false, 4),
       ('computer case Aerocool', true, 2),
       ('RAM Corsair', true, 3),
       ('SSD drive Samsung', true, 8),
       ('video card MSI', false, 1),
       ('motherboard GIGABYTE', true, 16),
       ('sound card DEXP', false, 0),
       ('processor Qualcomm', true, 23),
       ('lighting kit Alitove', false, 13),
       ('HDD drive Toshiba', false, 7),
       ('computer case Cougar', true, 13),
       ('RAM Kingston', true, 5),
       ('SSD drive Transcend', true, 11),
       ('video card GIGABYTE', false, 4);