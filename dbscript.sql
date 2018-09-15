DROP DATABASE IF EXISTS test;
CREATE DATABASE test CHARACTER SET utf8 COLLATE utf8_general_ci;

USE test;

DROP TABLE IF EXISTS part;
CREATE TABLE part(
  id        INT(11)      NOT NULL AUTO_INCREMENT,
  name      VARCHAR(100) NOT NULL,
  isNeeded  TINYINT      NOT NULL DEFAULT FALSE,
  amount    INT          NOT NULL DEFAULT '0',
  PRIMARY KEY (id))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO part (name, isNeeded, amount)
VALUES
       ('материнская плата ASUS', false, 3),
       ('звуковая карта ASUS', false, 2),
       ('процессор AMD', true, 2),
       ('подсветка корпуса DeepCool', false, 0),
       ('HDD диск Seagate', false, 1),
       ('корпус 3Cott', true, 10),
       ('память Crucial', true, 10),
       ('SSD диск AData', true, 15),
       ('видеокарта ASUS', false, 7),
       ('материнская плата MSI', true, 5),
       ('звуковая карта Creative', false, 9),
       ('процессор Intel', true, 7),
       ('подсветка корпуса NZXT', false, 14),
       ('HDD диск WD', false, 4),
       ('корпус Aerocool', true, 2),
       ('память Corsair', true, 3),
       ('SSD диск Samsung', true, 8),
       ('видеокарта MSI', false, 1),
       ('материнская плата GIGABYTE', true, 16),
       ('звуковая карта DEXP', false, 0),
       ('процессор Qualcomm', true, 23),
       ('подсветка корпуса Alitove', false, 13),
       ('HDD диск Toshiba', false, 7),
       ('корпус Cougar', true, 13),
       ('память Kingston', true, 5),
       ('SSD диск Transcend', true, 11),
       ('видеокарта GIGABYTE', false, 4);