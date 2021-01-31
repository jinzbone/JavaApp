/*
Navicat MySQL Data Transfer

Source Server         : jing
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-09-02 14:57:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', 'root', '123456');
INSERT INTO `t_user` VALUES ('3', 'zj', '123456');
INSERT INTO `t_user` VALUES ('4', 'gzh', '123456');
INSERT INTO `t_user` VALUES ('5', 'wy', '123456');
INSERT INTO `t_user` VALUES ('6', 'ym', '123456');
