/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : bookliabrary

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-03-10 16:25:35
*/
create database bookliabrary;
use bookliabrary;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(32) NOT NULL,
  `book_author` varchar(32) NOT NULL,
  `book_state` varchar(16) NOT NULL DEFAULT '未借',
  PRIMARY KEY (`book_id`),
  KEY `book_name` (`book_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('1', '史上最强轮回', '那一抹绯红', '未借');
INSERT INTO `book_info` VALUES ('2', '斗破苍穹', '天蚕土豆', '已借');
INSERT INTO `book_info` VALUES ('5', '龙王传说', '唐家三少', '未借');

-- ----------------------------
-- Table structure for login_info
-- ----------------------------
DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nickname` varchar(32) NOT NULL,
  `credits` smallint(6) NOT NULL DEFAULT '100' COMMENT '用户在图书系统的积分',
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_info
-- ----------------------------
INSERT INTO `login_info` VALUES ('1', '1', 'user', '12345', '小用户', '110');
INSERT INTO `login_info` VALUES ('2', '0', 'mrhu', 'mrhu123', '小胡先生', '100');
INSERT INTO `login_info` VALUES ('4', '1', 'beauty', 'beautygirl', '小美眉', '200');
INSERT INTO `login_info` VALUES ('6', '1', 'zhazha', 'zhazha123', '小渣渣', '39');
INSERT INTO `login_info` VALUES ('9', '999', '黑衣圣王', '黑衣永恒', '黑衣天命', '999');

-- ----------------------------
-- Table structure for rent_info
-- ----------------------------
DROP TABLE IF EXISTS `rent_info`;
CREATE TABLE `rent_info` (
  `rent_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `rent_book` varchar(32) NOT NULL,
  `rent_user` varchar(32) NOT NULL,
  `rent_credit` smallint(6) NOT NULL,
  `rent_date` datetime NOT NULL COMMENT '以当前日期now()作为值',
  `return_date` datetime NOT NULL COMMENT '在rent_date的基础上加30天:date_add(rent_date,interval 30 day)',
  `rent_daydiff` smallint(6) DEFAULT '0',
  PRIMARY KEY (`rent_id`),
  UNIQUE KEY `book_id_fk` (`book_id`) USING BTREE,
  KEY `rent_book` (`rent_book`),
  CONSTRAINT `book_id_fk` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rent_info
-- ----------------------------
INSERT INTO `rent_info` VALUES ('11', '2', '斗破苍穹', 'user', '96', '2017-03-08 16:53:36', '2017-04-12 16:53:36', '5');
