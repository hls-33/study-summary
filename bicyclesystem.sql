/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : hsadmin:3306
Source Database       : bicyclesystem

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-05-06 17:10:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aphone` varchar(11) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(64) NOT NULL,
  `idnumber` varchar(18) NOT NULL,
  `imagepath` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `aid` (`aid`,`aphone`),
  KEY `aphone` (`aphone`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '13400001234', '12345678', 'admin1', '513822100910088760', null);
INSERT INTO `admin` VALUES ('2', '15900329087', '123456', 'admin2', '123889991238841231', null);

-- ----------------------------
-- Table structure for admin_account
-- ----------------------------
DROP TABLE IF EXISTS `admin_account`;
CREATE TABLE `admin_account` (
  `acid` int(11) NOT NULL AUTO_INCREMENT,
  `aphone` varchar(11) DEFAULT NULL,
  `income` double unsigned zerofill DEFAULT NULL,
  `spending` double unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`acid`),
  KEY `ac` (`aphone`),
  CONSTRAINT `ac` FOREIGN KEY (`aphone`) REFERENCES `admin` (`aphone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_account
-- ----------------------------

-- ----------------------------
-- Table structure for bike_destroy
-- ----------------------------
DROP TABLE IF EXISTS `bike_destroy`;
CREATE TABLE `bike_destroy` (
  `bdid` int(11) NOT NULL AUTO_INCREMENT,
  `bikenumber` varchar(64) NOT NULL,
  `destroydate` varchar(32) NOT NULL,
  `bikename` varchar(64) NOT NULL,
  `kindname` varchar(64) NOT NULL,
  `shopname` varchar(64) NOT NULL,
  `imgpath` varchar(128) NOT NULL,
  PRIMARY KEY (`bdid`),
  KEY `dsfg` (`bikenumber`),
  KEY `rtr` (`bikename`),
  KEY `yh` (`kindname`),
  KEY `sde` (`shopname`),
  KEY `ef` (`imgpath`),
  CONSTRAINT `sde` FOREIGN KEY (`shopname`) REFERENCES `shop` (`shopname`),
  CONSTRAINT `yh` FOREIGN KEY (`kindname`) REFERENCES `bike_kind` (`kindname`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bike_destroy
-- ----------------------------
INSERT INTO `bike_destroy` VALUES ('16', 'bkshop1rent00005', '2017-05-02 19:45:07', 'JJ', '越野车', 'shop1', 'abcd');
INSERT INTO `bike_destroy` VALUES ('17', 'bkshop3rent00006', '2017-05-02 19:47:46', 'GG', '山地自行车', 'shop3', 'eqwh');
INSERT INTO `bike_destroy` VALUES ('18', 'bkshop2rent00007', '2017-05-02 19:51:43', 'forever', '山地自行车', 'shop2', 'caf');
INSERT INTO `bike_destroy` VALUES ('19', 'bkshop1rent00008', '2017-05-02 19:54:56', '迪卡侬', '越野车', 'shop1', 'daf');
INSERT INTO `bike_destroy` VALUES ('20', 'bkshop3rent00010', '17-05-05 09:32:59', '费舍尔', '越野车', 'shop3', 'imgs');
INSERT INTO `bike_destroy` VALUES ('21', 'bkshop3rent00009', '2017-05-05 09:36:29', '迪卡侬', '山地自行车', 'shop3', 'cagf');
INSERT INTO `bike_destroy` VALUES ('22', 'bkshop3rent00009', '2017-05-05 09:36:29', '迪卡侬', '山地自行车', 'shop3', 'cagf');
INSERT INTO `bike_destroy` VALUES ('28', '321', '2017-05-05 09:53:52', '321', '公路车', 'shop1', '321');
INSERT INTO `bike_destroy` VALUES ('29', '321', '2017-05-05 09:53:52', '321', '公路车', 'shop1', '321');
INSERT INTO `bike_destroy` VALUES ('30', '123', '2017-05-05 09:56:16', '123', '公路车', 'shop1', '123');

-- ----------------------------
-- Table structure for bike_kind
-- ----------------------------
DROP TABLE IF EXISTS `bike_kind`;
CREATE TABLE `bike_kind` (
  `bkid` int(11) NOT NULL AUTO_INCREMENT,
  `kindname` varchar(64) NOT NULL,
  `bkinformation` varchar(1024) NOT NULL,
  PRIMARY KEY (`bkid`),
  KEY `kindname` (`kindname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bike_kind
-- ----------------------------
INSERT INTO `bike_kind` VALUES ('1', '公路车', '专为公路稳行而生！');
INSERT INTO `bike_kind` VALUES ('2', '山地自行车', '可以跨越高山，翻越峻岭的飞车');
INSERT INTO `bike_kind` VALUES ('3', '越野车', '专为野马而生！');
INSERT INTO `bike_kind` VALUES ('4', '竞速车', '专为野马而生2！');

-- ----------------------------
-- Table structure for bike_rent
-- ----------------------------
DROP TABLE IF EXISTS `bike_rent`;
CREATE TABLE `bike_rent` (
  `brid` int(11) NOT NULL AUTO_INCREMENT,
  `bikenumber` varchar(64) NOT NULL,
  `bikename` varchar(64) NOT NULL,
  `color` varchar(64) NOT NULL,
  `kindname` varchar(64) NOT NULL,
  `shopname` varchar(64) NOT NULL,
  `hourprice` double unsigned DEFAULT '0',
  `dayprice` double unsigned DEFAULT '0',
  `isrented` varchar(255) NOT NULL DEFAULT '未出租',
  `imgpath` varchar(128) NOT NULL,
  `bikedeposit` double unsigned DEFAULT '0',
  `rentcount` int(11) DEFAULT '0',
  PRIMARY KEY (`brid`),
  KEY `afd` (`kindname`),
  KEY `as` (`shopname`),
  KEY `bikename` (`bikename`),
  KEY `bikenumber` (`bikenumber`),
  KEY `imgpath` (`imgpath`),
  CONSTRAINT `afd` FOREIGN KEY (`kindname`) REFERENCES `bike_kind` (`kindname`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `as` FOREIGN KEY (`shopname`) REFERENCES `shop` (`shopname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bike_rent
-- ----------------------------
INSERT INTO `bike_rent` VALUES ('7', 'bkshop1rent00001', '山地捷安特', '蓝色', '山地自行车', 'shop1', '12', '90', '已出租', '/bikesystem/image/hs/jat1.jpg', '1000', '21');
INSERT INTO `bike_rent` VALUES ('9', 'bkshop1rent00002', '公路捷安特', '蓝色', '公路车', 'shop1', '12', '100', '未出租', '/bikesystem/image/hs/jat3.jpg', '1000', '30');
INSERT INTO `bike_rent` VALUES ('12', 'bkshop1rent00003', '山地吉安特', '黄色', '公路车', 'shop2', '12', '100', '未出租', '/bikesystem/image/hs/jat4.jpg', '1000', '5');
INSERT INTO `bike_rent` VALUES ('23', 'bkshop1rent00004', '越野捷安特', '红色', '越野车', 'shop1', '30', '160', '未出租', '/bikesystem/image/hs/jat1.jpg', '2600', '36');
INSERT INTO `bike_rent` VALUES ('24', 'bkshop1rent00005', '儿童捷安特', '白色', '公路车', 'shop1', '10', '80', '未出租', '/bikesystem/image/hs/jat3.jpg', '1800', '19');
INSERT INTO `bike_rent` VALUES ('25', 'bkshop1rent00006', '竞速捷安特', '蓝色', '竞速车', 'shop1', '30', '290', '未出租', '/bikesystem/image/hs/jat4.jpg', '3200', '120');
INSERT INTO `bike_rent` VALUES ('26', 'bkshop1rent00007', '竞速安吉拉', '红白色', '竞速车', 'shop1', '35', '310', '未出租', '/bikesystem/image/hs/jat3.jpg', '3600', '170');
INSERT INTO `bike_rent` VALUES ('27', 'bkshop1rent00008', '公路安吉拉', '绿色', '公路车', 'shop1', '10', '80', '未出租', '/bikesystem/image/hs/jat1.jpg', '300', '78');

-- ----------------------------
-- Table structure for bike_sell
-- ----------------------------
DROP TABLE IF EXISTS `bike_sell`;
CREATE TABLE `bike_sell` (
  `bsid` int(11) NOT NULL AUTO_INCREMENT,
  `bikename` varchar(64) NOT NULL,
  `bikecount` int(10) unsigned zerofill NOT NULL,
  `color` varchar(32) NOT NULL,
  `kindname` varchar(64) NOT NULL,
  `shopname` varchar(64) NOT NULL,
  `bikeprice` double unsigned NOT NULL DEFAULT '0',
  `imgpath` varchar(128) NOT NULL,
  `sellcount` int(11) DEFAULT '0',
  `bikeheadinfo` varchar(1024) NOT NULL,
  `bikesubheadinfo` varchar(1024) NOT NULL,
  PRIMARY KEY (`bsid`),
  KEY `ad` (`kindname`),
  KEY `sd` (`shopname`),
  KEY `bikeprice` (`bikeprice`),
  KEY `bikename` (`bikename`),
  CONSTRAINT `ad` FOREIGN KEY (`kindname`) REFERENCES `bike_kind` (`kindname`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sd` FOREIGN KEY (`shopname`) REFERENCES `shop` (`shopname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bike_sell
-- ----------------------------
INSERT INTO `bike_sell` VALUES ('1', '永久山地车', '0000000010', '白色', '山地自行车', 'shop1', '625', '/bikesystem/image/hp/jat2.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('4', '永久山地车', '0000000005', '蓝色', '山地自行车', 'shop1', '625', '/bikesystem/image/hp/jat3.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('5', '永久山地车', '0000000006', '黑色', '山地自行车', 'shop1', '625', '/bikesystem/image/hp/jat1.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('6', '捷安特', '0000000004', '白色', '公路车', 'shop1', '1420', '/bikesystem/image/hp/jat2.jpg', '0', 'GIANT捷安特Escape R3铝合金车架公路自行车', '原装正品 实体同步销售 全国包邮 ');
INSERT INTO `bike_sell` VALUES ('7', '捷安特', '0000000005', '黑色', '公路车', 'shop1', '1420', '/bikesystem/image/hp/jat1.jpg', '0', 'GIANT捷安特Escape R3铝合金车架公路自行车', '原装正品 实体同步销售 全国包邮 ');
INSERT INTO `bike_sell` VALUES ('8', '幽马变速越野沙滩雪地车', '0000000006', '黄色', '越野车', 'shop1', '798', '/bikesystem/image/hp/ym1.jpg', '0', '幽马变速越野沙滩雪地车4.0超宽大轮胎山地自行车男女式学生单车', '越野性能强劲 回头率高 售后无忧');
INSERT INTO `bike_sell` VALUES ('9', '幽马变速越野沙滩雪地车', '0000000005', '白色', '越野车', 'shop1', '798', '/bikesystem/image/hp/ym2.jpg', '0', '幽马变速越野沙滩雪地车4.0超宽大轮胎山地自行车男女式学生单车', '越野性能强劲 回头率高 售后无忧');
INSERT INTO `bike_sell` VALUES ('10', '欧拜克', '0000000005', '红色', '竞速车', 'shop1', '868', '/bikesystem/image/hp/op1.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');
INSERT INTO `bike_sell` VALUES ('11', '欧拜克', '0000000006', '白色', '竞速车', 'shop1', '868', '/bikesystem/image/hp/op2.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');
INSERT INTO `bike_sell` VALUES ('12', '永久山地车', '0000000010', '白色', '山地自行车', 'shop2', '625', '/bikesystem/image/hp/jat2.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('13', '永久山地车', '0000000005', '蓝色', '山地自行车', 'shop2', '625', '/bikesystem/image/hp/jat3.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('14', '永久山地车', '0000000006', '黑色', '山地自行车', 'shop2', '625', '/bikesystem/image/hp/jat1.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('15', '捷安特', '0000000004', '白色', '公路车', 'shop2', '1420', '/bikesystem/image/hp/jat6.jpg', '0', 'GIANT捷安特Escape R3铝合金车架公路自行车', '原装正品 实体同步销售 全国包邮 ');
INSERT INTO `bike_sell` VALUES ('16', '捷安特', '0000000005', '黑色', '公路车', 'shop2', '1420', '/bikesystem/image/hp/jat1.jpg', '0', 'GIANT捷安特Escape R3铝合金车架公路自行车', '原装正品 实体同步销售 全国包邮 ');
INSERT INTO `bike_sell` VALUES ('17', '捷安特', '0000000007', '蓝色', '公路车', 'shop2', '1420', '/bikesystem/image/hp/jat3.jpg', '0', 'GIANT捷安特Escape R3铝合金车架公路自行车', '原装正品 实体同步销售 全国包邮 ');
INSERT INTO `bike_sell` VALUES ('18', '幽马变速越野沙滩雪地车', '0000000006', '黄色', '越野车', 'shop2', '798', '/bikesystem/image/hp/ym1.jpg', '0', '幽马变速越野沙滩雪地车4.0超宽大轮胎山地自行车男女式学生单车', '越野性能强劲 回头率高 售后无忧');
INSERT INTO `bike_sell` VALUES ('19', '幽马变速越野沙滩雪地车', '0000000005', '白色', '越野车', 'shop2', '798', '/bikesystem/image/hp/ym2.jpg', '0', '幽马变速越野沙滩雪地车4.0超宽大轮胎山地自行车男女式学生单车', '越野性能强劲 回头率高 售后无忧');
INSERT INTO `bike_sell` VALUES ('20', '欧拜克', '0000000005', '红色', '竞速车', 'shop2', '868', '/bikesystem/image/hp/op1.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');
INSERT INTO `bike_sell` VALUES ('21', '欧拜克', '0000000006', '白色', '竞速车', 'shop2', '868', '/bikesystem/image/hp/op2.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');
INSERT INTO `bike_sell` VALUES ('22', '永久山地车', '0000000010', '蓝色', '山地自行车', 'shop3', '625', '/bikesystem/image/hp/jat3.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('23', '永久山地车', '0000000005', '黑色', '山地自行车', 'shop3', '625', '/bikesystem/image/hp/jat1.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('24', '永久山地车', '0000000006', '白色', '山地自行车', 'shop3', '625', '/bikesystem/image/hp/jat2.jpg', '0', '永久自行车山地车铝合金架减震双碟刹男女式山地车YE880', 'YE880镇店之款总销19万辆多种配置');
INSERT INTO `bike_sell` VALUES ('25', '捷安特', '0000000004', '黑色', '公路车', 'shop3', '1420', '/bikesystem/image/hp/jat5.jpg', '0', 'GIANT捷安特Escape R3铝合金车架公路自行车', '原装正品 实体同步销售 全国包邮 ');
INSERT INTO `bike_sell` VALUES ('26', '捷安特', '0000000005', '蓝色', '公路车', 'shop3', '1420', '/bikesystem/image/hp/jat3.jpg', '0', 'GIANT捷安特Escape R3铝合金车架公路自行车', '原装正品 实体同步销售 全国包邮 ');
INSERT INTO `bike_sell` VALUES ('27', '捷安特', '0000000007', '黄色', '公路车', 'shop3', '1420', '/bikesystem/image/hp/jat4.jpg', '0', 'GIANT捷安特Escape R3铝合金车架公路自行车', '原装正品 实体同步销售 全国包邮 ');
INSERT INTO `bike_sell` VALUES ('28', '幽马变速越野沙滩雪地车', '0000000006', '白色', '越野车', 'shop3', '798', '/bikesystem/image/hp/ym2.jpg', '0', '幽马变速越野沙滩雪地车4.0超宽大轮胎山地自行车男女式学生单车', '越野性能强劲 回头率高 售后无忧');
INSERT INTO `bike_sell` VALUES ('29', '幽马变速越野沙滩雪地车', '0000000005', '黄色', '越野车', 'shop3', '798', '/bikesystem/image/hp/ym1.jpg', '0', '幽马变速越野沙滩雪地车4.0超宽大轮胎山地自行车男女式学生单车', '越野性能强劲 回头率高 售后无忧');
INSERT INTO `bike_sell` VALUES ('30', '欧拜克', '0000000005', '白色', '竞速车', 'shop3', '868', '/bikesystem/image/hp/op2.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');
INSERT INTO `bike_sell` VALUES ('31', '欧拜克', '0000000006', '蓝色', '竞速车', 'shop3', '868', '/bikesystem/image/hp/op3.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');
INSERT INTO `bike_sell` VALUES ('33', '欧拜克', '0000000020', '红色', '竞速车', 'shop3', '12999', '/bikesystem/image/hp/op1.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');
INSERT INTO `bike_sell` VALUES ('34', '欧拜克', '0000000020', '蓝色', '竞速车', 'shop2', '12999', '/bikesystem/image/hp/op3.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');
INSERT INTO `bike_sell` VALUES ('35', '欧拜克', '0000000020', '蓝色', '竞速车', 'shop1', '12999', '/bikesystem/image/hp/op3.jpg', '0', '欧拜克越野学生公路自行车三刀一体轮700C碟刹公路赛跑车', '三刀轮/破风轮，碟刹款。');

-- ----------------------------
-- Table structure for bike_sell_info
-- ----------------------------
DROP TABLE IF EXISTS `bike_sell_info`;
CREATE TABLE `bike_sell_info` (
  `bsiid` int(11) NOT NULL AUTO_INCREMENT,
  `bsid` int(11) NOT NULL,
  `shopname` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `bikeprice` double unsigned DEFAULT '0',
  `selldate` varchar(32) NOT NULL,
  PRIMARY KEY (`bsiid`),
  KEY `af` (`shopname`),
  KEY `we` (`bikeprice`),
  KEY `au` (`name`),
  KEY `sell_info_bsid` (`bsid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bike_sell_info
-- ----------------------------
INSERT INTO `bike_sell_info` VALUES ('2', '1', 'shop1', '赵姝', '1420', '2017-05-06');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `shopname` varchar(64) NOT NULL,
  `bikename` varchar(64) NOT NULL,
  `message` varchar(1024) NOT NULL,
  `commentdate` varchar(32) NOT NULL,
  `commentImgPath` varchar(126) DEFAULT NULL,
  `commentStatus` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `qq` (`name`),
  KEY `sq` (`shopname`),
  KEY `ds` (`bikename`),
  CONSTRAINT `dsa` FOREIGN KEY (`bikename`) REFERENCES `bike_rent` (`bikename`),
  CONSTRAINT `qq` FOREIGN KEY (`name`) REFERENCES `user` (`name`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `sq` FOREIGN KEY (`shopname`) REFERENCES `shop` (`shopname`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('5', '赵姝', 'shop1', '公路捷安特', 'ddd', 'sdf', 'ddd', '好评');
INSERT INTO `comment` VALUES ('6', '赵姝', 'shop1', '公路捷安特', 'dsfsfas', '2015566', '5464impahth', '好评');

-- ----------------------------
-- Table structure for comment_sell
-- ----------------------------
DROP TABLE IF EXISTS `comment_sell`;
CREATE TABLE `comment_sell` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `shopname` varchar(64) DEFAULT NULL,
  `bikename` varchar(30) DEFAULT NULL,
  `message` varchar(128) DEFAULT NULL,
  `commentdate` varchar(50) DEFAULT NULL,
  `commentimagepath` varchar(256) DEFAULT NULL,
  `commentstatus` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `shopname2` (`shopname`),
  KEY `name2` (`name`),
  KEY `bikename2` (`bikename`),
  CONSTRAINT `bikename2` FOREIGN KEY (`bikename`) REFERENCES `bike_sell` (`bikename`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `name2` FOREIGN KEY (`name`) REFERENCES `admin` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shopname2` FOREIGN KEY (`shopname`) REFERENCES `shop` (`shopname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_sell
-- ----------------------------
INSERT INTO `comment_sell` VALUES ('2', 'admin1', 'shop1', '永久山地车', '11', 'wer', 'adf', '好评');

-- ----------------------------
-- Table structure for sell_address
-- ----------------------------
DROP TABLE IF EXISTS `sell_address`;
CREATE TABLE `sell_address` (
  `said` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `uesrname` varchar(64) NOT NULL,
  `address` varchar(64) NOT NULL,
  `minuteaddress` varchar(1024) NOT NULL,
  `phone` varchar(128) NOT NULL,
  PRIMARY KEY (`said`),
  KEY `name` (`name`),
  CONSTRAINT `name` FOREIGN KEY (`name`) REFERENCES `user` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sell_address
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `shopname` varchar(64) NOT NULL,
  `shopaddress` varchar(128) NOT NULL,
  `shopbuildtime` varchar(64) NOT NULL,
  `shopinformation` varchar(1024) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `shopname` (`shopname`),
  KEY `aid` (`aid`),
  CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `admin` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '1', 'shop1', '中东省战乱地带', '2017-04-30', '这是折扣商店');
INSERT INTO `shop` VALUES ('2', '2', 'shop2', '金星环绕陨石群第134235颗陨星中心', '2017-04-30', '这是赤裸裸的黑店哦！');
INSERT INTO `shop` VALUES ('3', '2', 'shop3', '火星', '2017-04-30', '火星特产专卖店');

-- ----------------------------
-- Table structure for shop_image
-- ----------------------------
DROP TABLE IF EXISTS `shop_image`;
CREATE TABLE `shop_image` (
  `siid` int(11) NOT NULL AUTO_INCREMENT,
  `shopname` varchar(64) NOT NULL,
  `imagename` varchar(128) NOT NULL,
  `imagepath` varchar(256) NOT NULL,
  PRIMARY KEY (`siid`),
  KEY `shop` (`shopname`),
  CONSTRAINT `shop` FOREIGN KEY (`shopname`) REFERENCES `shop` (`shopname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_image
-- ----------------------------
INSERT INTO `shop_image` VALUES ('1', 'shop1', 'headImage', '/bikesystem/image/hs/headImage1.jpg');
INSERT INTO `shop_image` VALUES ('2', 'shop1', 'navImage', '/bikesystem/image/hs/navImage1.jpg');
INSERT INTO `shop_image` VALUES ('3', 'shop1', 'navImage', '/bikesystem/image/hs/navImage2.jpg');
INSERT INTO `shop_image` VALUES ('4', 'shop1', 'hotRentImage', '/bikesystem/image/hs/热租商品.png');
INSERT INTO `shop_image` VALUES ('5', 'shop1', 'hotSellImage', '/bikesystem/image/hs/热销商品.jpg');
INSERT INTO `shop_image` VALUES ('6', 'shop1', 'backgroundImage', '/bikesystem/image/hs/shopbackground.jpg');

-- ----------------------------
-- Table structure for shop_rent_sale
-- ----------------------------
DROP TABLE IF EXISTS `shop_rent_sale`;
CREATE TABLE `shop_rent_sale` (
  `srid` int(11) NOT NULL AUTO_INCREMENT,
  `brid` int(11) NOT NULL,
  `shopname` varchar(255) NOT NULL,
  `hoursaleprice` decimal(10,2) NOT NULL DEFAULT '0.00',
  `daysaleprice` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`srid`),
  KEY `sr_brid` (`brid`),
  KEY `sr_shopname` (`shopname`),
  CONSTRAINT `sr_brid` FOREIGN KEY (`brid`) REFERENCES `bike_rent` (`brid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sr_shopname` FOREIGN KEY (`shopname`) REFERENCES `shop` (`shopname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_rent_sale
-- ----------------------------
INSERT INTO `shop_rent_sale` VALUES ('2', '12', 'shop2', '0.00', '-8.88');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uphone` varchar(11) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(64) NOT NULL,
  `idnumber` varchar(18) NOT NULL,
  `sex` varchar(8) NOT NULL,
  `address` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `balance` double unsigned DEFAULT '0',
  PRIMARY KEY (`uid`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18285639452', '01234567', '赵姝', '123123124123123141', '女', '重庆', '23345465@sina.cn', '0');
INSERT INTO `user` VALUES ('2', '18780528059', '1234567890', '张三', '513901199612143052', '男', '四川省成都市', '230294668512@qq.com', '0');

-- ----------------------------
-- Table structure for user_rent
-- ----------------------------
DROP TABLE IF EXISTS `user_rent`;
CREATE TABLE `user_rent` (
  `urid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `bikenumber` varchar(128) NOT NULL,
  `bikename` varchar(64) NOT NULL,
  `shopname` varchar(64) NOT NULL,
  `rentdate` varchar(32) NOT NULL,
  `returndate` varchar(32) NOT NULL,
  `deposit` double unsigned DEFAULT '0',
  PRIMARY KEY (`urid`),
  KEY `su` (`name`),
  KEY `bikenumber` (`bikenumber`),
  KEY `bikename` (`bikename`),
  KEY `shopname` (`shopname`),
  CONSTRAINT `bikename` FOREIGN KEY (`bikename`) REFERENCES `bike_rent` (`bikename`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bikenumber` FOREIGN KEY (`bikenumber`) REFERENCES `bike_rent` (`bikenumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shopname` FOREIGN KEY (`shopname`) REFERENCES `shop` (`shopname`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `su` FOREIGN KEY (`name`) REFERENCES `user` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_rent
-- ----------------------------
INSERT INTO `user_rent` VALUES ('1', '赵姝', 'bkshop1rent00001', '山地捷安特', 'shop1', '2017-05-04', '2017-05-07', '1500');
