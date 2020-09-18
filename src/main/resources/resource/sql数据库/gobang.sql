/*
Navicat MySQL Data Transfer

Source Server         : java
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : fivechess

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2016-09-26 20:17:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `gobang_user` (
  `name` varchar(30) NOT NULL,
  `fileName` varchar(50) DEFAULT NULL,
  `winNum` int(20) DEFAULT NULL,
  `loseNum` int(20) DEFAULT NULL,
  `tiedNum` int(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `gobang_server`;
CREATE TABLE `gobang_server` (
  `ip` varchar(30) NOT NULL
  PRIMARY KEY (`ip`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

